package com.xixisdk.xixiweatherutils;

import android.text.TextUtils;

import com.xixi.sdk.parser.LLGsonUtils;
import com.xixi.sdk.utils.network.LLException;
import com.xixi.sdk.utils.thread.UIThreadDispatcher;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2019/6/10.
 */

public abstract class CallBackWeather<T extends WeatherResult> implements Callback {

    public CallBackWeather() {
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    public abstract Class<T> _getClass();

    public abstract void onLLResponse(Call arg0, Response arg1, T o);

    public abstract void onLLFailure(Call arg0, Throwable arg1);

    public void onGeneralFailure(Call arg0, Throwable arg1) {

        onGeneralHandleError(arg1);
        onLLFailure(arg0, arg1);
    }

    private boolean onGeneralHandleError(Throwable arg1) {
        if (arg1 instanceof LLException.LLNetworkException) {
            return true;
        } else
            return false;
    }

    @Override
    public void onResponse(final Call arg0, final Response arg1) throws IOException {
        String strJson = null;
        T o = null;
        ResponseBody res = null;
        try {
            if (!arg1.isSuccessful()) {
                throw new LLException.LLIncorrectHttpCodeException(arg1.code());
            }
            res = arg1.body();
            strJson = arg1.body().string();
            o = (T) LLGsonUtils.fromJson(strJson, _getClass());
            if (o == null) {
                throw new LLException.LLMalFormatOfJsonException(strJson);
            }

            final T o1 = o;
            if (TextUtils.isEmpty(o1.getStatus_code())) {
                throw new LLException.LLCmdErrorException(strJson);
            }

            UIThreadDispatcher.dispatch(new Runnable() {
                public void run() {
                    onLLResponse(arg0, arg1, o1);
                }
            });
        } catch (final Exception e) {
            UIThreadDispatcher.dispatch(new Runnable() {
                public void run() {
                    onGeneralFailure(arg0, e);
                }
            });
        } finally {
            try {
                try {
                    if (res != null)
                        res.close();
                } catch (Exception e) {
                }
            } catch (Exception e) {
            }

        }
    }
}

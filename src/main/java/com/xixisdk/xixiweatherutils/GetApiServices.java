package com.xixisdk.xixiweatherutils;

import com.xixi.sdk.globals.LLSdkGlobals;
import com.xixi.sdk.utils.network.LLSdkRetrofitUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019/6/5.
 */

public class GetApiServices extends LLSdkGlobals {
    private static String mStrBaseUrl;

    static {
        if (ENABLE_HTTPS) {
            mStrBaseUrl = "https://39.104.111.137/appreg/device/weather/";
        } else {
            mStrBaseUrl = "http://39.104.111.137/appreg/device/weather/";
        }
    }

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(mStrBaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).client(LLSdkRetrofitUtils.generateClientObject()).build();


    public static Call<ResponseBody> queryWeather(String deviceName, String deviceType) {
        return retrofit.create(IGetWeather.class).queryWeather(deviceName, deviceType);
    }


    public interface IGetWeather {
        @GET("deviceName/{deviceName}/deviceType/{deviceType}")
        Call<ResponseBody> queryWeather(@Path("deviceName") String deviceName, @Path("deviceType") String deviceType);
    }
}

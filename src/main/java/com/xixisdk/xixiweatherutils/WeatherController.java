package com.xixisdk.xixiweatherutils;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xixi.sdk.app.LongLakeApplication;
import com.xixi.sdk.controller.LLNotifier;
import com.xixi.sdk.utils.file.IoCompletionListener;
import com.xixi.sdk.utils.file.IoCompletionListener1;
import com.xixi.sdk.utils.thread.LLThreadPool;
import com.xixi.sdk.utils.thread.UIThreadDispatcher;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Administrator on 2019/6/10.
 */

public class WeatherController extends LLNotifier<XiXiWeatherListener> {
    private static WeatherController instance;
    private final static int RUNNABLE_TIMER = 30 * 60000;
    private final Runnable WEATHER_DATA_RUNNABLE = new Runnable() {
        @Override
        public void run() {
//                getWeather(new IoCompletionListener1<Boolean>() {
//                    @Override
//                    public void onFinish(Boolean data, Object context) {
//                        if (data) {
//                            notifyOb(new Object[]{mWeatherData});
//                        }
//                    }
//                });

            UIThreadDispatcher.dispatch(WEATHER_DATA_RUNNABLE, RUNNABLE_TIMER);
        }
    };

    private WeatherController() {
        WEATHER_DATA_RUNNABLE.run();
    }

    public static WeatherController getInstance() {
        if (instance == null) {
            synchronized (WeatherController.class) {
                if (instance == null) {
                    instance = new WeatherController();
                }
            }
        }
        return instance;
    }

//    public void getWeather(final IoCompletionListener1<Boolean> weatherData) {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.seniverse.com/v3/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//
//        GetApiServices weatherApi = retrofit.create(GetApiServices.class);
//        Map<String, String> map = new HashMap<>();
//        map.put("key", "S2CH1NyrjVi05-Dcd");
//        map.put("location", "ip");
//        Call<WeatherEntity> call = weatherApi.getWeather(map);
//        Call<WeatherLifeEntity> callLife = weatherApi.getWeatherLife(map);
//        call.enqueue(new CallBackWeather<WeatherEntity>() {
//            @Override
//            public Class<WeatherEntity> _getClass() {
//                return WeatherEntity.class;
//            }
//
//            @Override
//            public void onLLResponse(okhttp3.Call arg0, okhttp3.Response arg1, WeatherEntity o) {
//                weatherData.onFinish(true, getWeatherData());
//            }
//
//            @Override
//            public void onLLFailure(okhttp3.Call arg0, Throwable arg1) {
//                weatherData.onFinish(false, android.util.Log.getStackTraceString(arg1));
//            }
//        });
//
//        callLife.enqueue(new Callback<WeatherLifeEntity>() {
//            @Override
//            public void onResponse(Call<WeatherLifeEntity> call, Response<WeatherLifeEntity> response) {
//                WeatherLifeEntity entity = response.body();
//                String mStrSport = entity.getResults().get(0).getSuggestion().getSport().getBrief();
//            }
//
//            @Override
//            public void onFailure(Call<WeatherLifeEntity> call, Throwable t) {
//                Log.i(LongLakeApplication.DANIEL_TAG, "onFailure:" + t.getMessage());
//            }
//        });
//    }
//    public static class WeatherData {
//
//    }

    private WeatherEntity DEFAULT_NULL_WEATHERENTITY = new WeatherEntity();
    private WeatherEntity mWeatherData = new WeatherEntity();

    public WeatherEntity getWeatherData() {
        if (mWeatherData == null) {
            return DEFAULT_NULL_WEATHERENTITY;
        }
        return mWeatherData;
    }

    @Override
    protected void invoke(XiXiWeatherListener xiXiWeatherListener, Object[] o1) {
        xiXiWeatherListener.onWeatherData((WeatherEntity) o1[0]);
        xiXiWeatherListener.onWeatherLifeData((WeatherLifeEntity) o1[0]);

    }
}

package com.xixisdk.xixiweatherutils;

import com.xixi.sdk.app.LongLakeApplication;
import com.xixi.sdk.controller.LLNotifier;
import com.xixi.sdk.utils.file.IoCompletionListener1;
import com.xixi.sdk.utils.thread.UIThreadDispatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/10.
 */

public class WeatherController extends LLNotifier<XiXiWeatherListener> {
    private static WeatherController instance;
    private final static int RUNNABLE_TIMER = 30 * 60000;
    private final Runnable WEATHER_DATA_RUNNABLE = new Runnable() {
        @Override
        public void run() {
//            getWeather(new IoCompletionListener1<Boolean>() {
//                @Override
//                public void onFinish(Boolean data, Object context) {
//                    if (data) {
//                        notifyOb(new Object[]{mWeatherData});
//                    }
//                }
//            });

            UIThreadDispatcher.dispatch(WEATHER_DATA_RUNNABLE, RUNNABLE_TIMER);
        }
    };

    private WeatherController() {
        WEATHER_DATA_RUNNABLE.run();
    }
    private static Map<String, Integer> mWeatherMap = new HashMap<>();

    private static Map<String, String> mLifeMap = new HashMap<>();

    static {
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_scorching_hot), LongLakeApplication.getInstance().getString(R.string.weather_scorching_hot_dress));
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_hot), LongLakeApplication.getInstance().getString(R.string.weather_hot_dress));
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_comfortable), LongLakeApplication.getInstance().getString(R.string.weather_comfortable_dress));
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_more_comfortable), LongLakeApplication.getInstance().getString(R.string.weather_more_comfortable_dress));
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_colder), LongLakeApplication.getInstance().getString(R.string.weather_colder_dress));
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_cold), LongLakeApplication.getInstance().getString(R.string.weather_cold_dress));
        mLifeMap.put(LongLakeApplication.getInstance().getString(R.string.weather_frigid), LongLakeApplication.getInstance().getString(R.string.weather_frigid_dress));

        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_sunny), R.mipmap.weather0);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_clear), R.mipmap.weather1);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_cloudy), R.mipmap.weather4);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_partly_cloudy), R.mipmap.weather5);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_partly_cloudy_night), R.mipmap.weather6);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_mostly_cloudy), R.mipmap.weather7);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_mostly_cloudy_night), R.mipmap.weather8);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_overcast), R.mipmap.weather9);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_shower), R.mipmap.weather10);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_thundershower), R.mipmap.weather11);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_thundershower_with_hail), R.mipmap.weather12);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_light_rain), R.mipmap.weather13);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_moderate_rain), R.mipmap.weather14);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_heavy_rain), R.mipmap.weather15);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_storm), R.mipmap.weather16);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_heavy_storm), R.mipmap.weather17);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_severe_storm), R.mipmap.weather18);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_ice_rain), R.mipmap.weather19);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_sleet), R.mipmap.weather20);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_snow_flurry), R.mipmap.weather21);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_light_snow), R.mipmap.weather22);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_moderate_snow), R.mipmap.weather23);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_heavy_snow), R.mipmap.weather24);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_snowstorm), R.mipmap.weather25);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_dust), R.mipmap.weather26);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_sand), R.mipmap.weather27);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_duststorm), R.mipmap.weather28);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_sandstorm), R.mipmap.weather29);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_foggy), R.mipmap.weather30);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_haze), R.mipmap.weather31);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_windy), R.mipmap.weather32);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_blustery), R.mipmap.weather33);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_hurricane), R.mipmap.weather34);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_tropical_storm), R.mipmap.weather35);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_tornado), R.mipmap.weather36);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_cold_low), R.mipmap.weather37);
        mWeatherMap.put(LongLakeApplication.getInstance().getString(R.string.weather_hot_low), R.mipmap.weather38);
    }


    public Map<String, Integer> getWeatherImg() {
        return mWeatherMap;
    }

    public Map<String, String> getWeatherLife() {
        return mLifeMap;
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

    private String deviceName, timestamp;
    private static final String DEVICE_TYPE = "DU";

    public void getWeather(final IoCompletionListener1<Boolean> weatherData) {
//        GetApiServices.queryWeather(deviceName, DEVICE_TYPE, null).enqueue(new CallBackWeather<WeatherEntity>() {
//
//            @Override
//            public Class<WeatherEntity> _getClass() {
//                return WeatherEntity.class;
//            }
//
//            @Override
//            public void onLLResponse(Call arg0, Response arg1, WeatherEntity o) {
//                weatherData.onFinish(true, getWeatherData());
//            }
//
//            @Override
//            public void onLLFailure(Call arg0, Throwable arg1) {
//                weatherData.onFinish(false, android.util.Log.getStackTraceString(arg1));
//            }
//        });
    }

    public static class WeatherData {

    }

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
    }
}

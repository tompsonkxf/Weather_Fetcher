package com.xixisdk.xixiweatherutils;

import android.util.ArrayMap;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2019/6/5.
 */

public interface GetApiServices {
    @GET("weather/now.json")
    Call<WeatherEntity> getWeather(@QueryMap Map<String, String> params);
    @GET("life/suggestion.json")
    Call<WeatherLifeEntity> getWeatherLife(@QueryMap Map<String, String> params);
}

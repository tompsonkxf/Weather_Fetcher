package com.xixisdk.xixiweatherutils;

/**
 * Created by Administrator on 2019/6/10.
 */

public interface XiXiWeatherListener {
    void onWeatherData(WeatherEntity weatherData) ;
    void onWeatherLifeData(WeatherLifeEntity weatherData) ;
}

package com.xixisdk.xixiweatherutils;

import android.util.ArrayMap;

import com.xixi.sdk.utils.network.LLSdkRetrofitUtils;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2019/6/5.
 */

public class GetApiServices extends LLSdkRetrofitUtils {
   private static Retrofit retrofit = new Retrofit.Builder().baseUrl("http://39.104.111.137:8080/appreg/device/weather/")
            .addConverterFactory(GsonConverterFactory.create()).build();


    public static Call<ResponseBody> queryWeather(String deviceName, String deviceType, String timestamp) {
        return retrofit.create(IGetWeather.class).queryWeather(deviceName, deviceType, timestamp);
    }


    public interface IGetWeather {
        @GET("deviceName/{deviceName}/deviceType/{deviceType}/timestamp/{timestamp}")
        Call<ResponseBody> queryWeather(@Path("deviceName") String deviceName, @Path("deviceType") String deviceType,
                                      @Path("timestamp") String timestamp);
    }
}

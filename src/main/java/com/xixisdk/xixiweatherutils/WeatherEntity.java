package com.xixisdk.xixiweatherutils;

import android.text.TextUtils;

import com.xixi.sdk.LLSDKUtils;
import com.xixi.sdk.app.LongLakeApplication;
import com.xixi.sdk.utils.network.LLRet;

/**
 * Created by Administrator on 2019/6/5.
 */

public class WeatherEntity extends LLRet {
    public WeatherEntity(){}
    public WeatherEntity(String msg, DataBean data) {
        this.msg = msg;
        this.data = data;
    }

    /**
     * ret : success
     * msg : null
     * data : {"day":"多云","night":"多云","tempHigh":"25","tempLow":"18","brief":"舒适","details":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"}
     */

    private String msg;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        public DataBean(String day, String night, String tempHigh, String tempLow, String brief, String details) {
            this.day = day;
            this.night = night;
            this.tempHigh = tempHigh;
            this.tempLow = tempLow;
            this.brief = brief;
            this.details = details;
        }

        /**
         * day : 多云
         * night : 多云
         * tempHigh : 25
         * tempLow : 18
         * brief : 舒适
         * details : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
         */

        private  String day;
        private  String night;
        private  String tempHigh ;
        private  String tempLow;
        private  String brief;
        private  String details;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getNight() {
            return night;
        }

        public void setNight(String night) {
            this.night = night;
        }

        public String getTempHigh() {
            return TextUtils.isEmpty(tempHigh)?LLSDKUtils.getString(R.string.weather_temp_high):tempHigh;
        }

        public void setTempHigh(String tempHigh) {
            this.tempHigh = tempHigh;
        }

        public String getTempLow() {
            return TextUtils.isEmpty(tempLow)? LLSDKUtils.getString(R.string.weather_temp_low):tempLow;
        }

        public void setTempLow(String tempLow) {
            this.tempLow = tempLow;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}

package com.xixisdk.xixiweatherutils;

/**
 * Created by Administrator on 2019/6/5.
 */

public class WeatherEntity {

    /**
     * ret : success
     * msg : null
     * data : {"day":"多云","night":"多云","tempHigh":"30","tempLow":"20","brief":"热","details":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"}
     */

    private String ret;
    private Object msg;
    private DataBean data;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * day : 多云
         * night : 多云
         * tempHigh : 30
         * tempLow : 20
         * brief : 热
         * details : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
         */

        private String day;
        private String night;
        private String tempHigh;
        private String tempLow;
        private String brief;
        private String details;

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
            return tempHigh;
        }

        public void setTempHigh(String tempHigh) {
            this.tempHigh = tempHigh;
        }

        public String getTempLow() {
            return tempLow;
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

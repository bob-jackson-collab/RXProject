package com.ys.rx_project;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Weather {

    private WeatherData data;


    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    class WeatherData{
        private String ganmao;


        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }
    }
}

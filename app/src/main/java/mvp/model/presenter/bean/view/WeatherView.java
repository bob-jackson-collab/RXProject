package mvp.model.presenter.bean.view;

import mvp.model.presenter.bean.WeatherData;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface WeatherView {

    void showProgress();
    void hideProgress();
    void getWeatherData(WeatherData weatherData);
}

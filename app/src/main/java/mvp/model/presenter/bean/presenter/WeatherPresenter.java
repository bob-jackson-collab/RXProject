package mvp.model.presenter.bean.presenter;

import mvp.model.presenter.bean.model.WeatherModeImp;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface WeatherPresenter {

    public void getWeatherData(String format,String city);
}

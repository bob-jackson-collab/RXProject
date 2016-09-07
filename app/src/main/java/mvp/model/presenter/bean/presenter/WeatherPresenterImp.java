package mvp.model.presenter.bean.presenter;

import android.util.Log;

import mvp.model.presenter.bean.model.WeatherModeImp;
import mvp.model.presenter.bean.model.WeatherModel;
import mvp.model.presenter.bean.view.WeatherView;

/**
 * Created by Administrator on 2016/9/7.
 */
public class WeatherPresenterImp implements WeatherPresenter,WeatherModeImp.WeatherOnListener{

    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImp(WeatherView weatherView){
        this.weatherView = weatherView;
        weatherModel = new WeatherModeImp(this);
    }
    @Override
    public void onSuccess(WeatherData weatherData) {
        weatherView.hideProgress();
        weatherView.getWeatherData(weatherData);
    }

    @Override
    public void onFailure(Throwable e) {
        weatherView.hideProgress();
        Log.e("info",e.getMessage());
    }

    @Override
    public void getWeatherData(String format, String city) {
        weatherView.showProgress();
        weatherModel.getWeatherData(format,city);
    }
}

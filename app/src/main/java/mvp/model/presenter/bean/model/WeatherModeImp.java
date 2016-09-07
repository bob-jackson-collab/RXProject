package mvp.model.presenter.bean.model;

import mvp.model.presenter.bean.WeatherData;
import mvp.model.presenter.bean.api.ApiManager;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/7.
 */
public class WeatherModeImp implements WeatherModel{

    private WeatherOnListener weatherOnListener;

    public WeatherModeImp(WeatherOnListener weatherOnListener){
        this.weatherOnListener = weatherOnListener;
    }
    @Override
    public void getWeatherData(String format, String city) {
        ApiManager.getWeatherData(format,city).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherData>() {
                    @Override
                    public void call(WeatherData weatherData) {
                        weatherOnListener.onSuccess(weatherData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        weatherOnListener.onFailure(throwable);
                    }
                });
    }



    public interface WeatherOnListener{
        public void onSuccess(WeatherData weatherData);
        public void onFailure(Throwable e);
    }
}

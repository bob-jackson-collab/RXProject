package mvp.model.presenter.bean.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ys.rx_project.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.model.presenter.bean.WeatherData;
import mvp.model.presenter.bean.presenter.WeatherPresenter;
import mvp.model.presenter.bean.presenter.WeatherPresenterImp;

/**
 * Created by Administrator on 2016/9/7.
 */
public class WeatherActivity extends Activity implements WeatherView{

    @Bind(R.id.text_weather)
    private TextView text_weather;
    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_view);
        ButterKnife.bind(this);

        weatherPresenter = new WeatherPresenterImp(this);
        weatherPresenter.getWeatherData("2","苏州");
    }

    @Override
    public void showProgress() {
        Log.e("info","显示进度条");
    }

    @Override
    public void hideProgress() {
        Log.e("info","隐藏进度条");
    }

    @Override
    public void getWeatherData(WeatherData weatherData) {
        text_weather.setText(weatherData.getReason());
    }


}

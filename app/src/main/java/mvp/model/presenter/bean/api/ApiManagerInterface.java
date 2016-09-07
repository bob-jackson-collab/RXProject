package mvp.model.presenter.bean.api;

import mvp.model.presenter.bean.WeatherData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface ApiManagerInterface {

    @GET("/weather/index")
    Observable<WeatherData> getWeatherData(@Query("format") String format, @Query("city") String city, @Query("key") String key);
}

package mvp.model.presenter.bean.api;

import mvp.model.presenter.bean.WeatherData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ApiManager {

    private final static String BASEURL = "http://v.juhe.cn";
    private final static Retrofit  mRetrofit = new Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    private static ApiManagerInterface apiManagerInterface = mRetrofit.create(ApiManagerInterface.class);

    public static Observable<WeatherData> getWeatherData(String format, String city){
        return apiManagerInterface.getWeatherData(format,city,"ad1d20bebafe0668502c8eea5ddd0333");
    }
}

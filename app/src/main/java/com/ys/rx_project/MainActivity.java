package com.ys.rx_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private Subscriber<MovieInfo> subscriber;
    private Subscriber<MovieInfo> subscriber1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getIWeather().getWeather("深圳").subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Weather>() {
//                    @Override
//                    public void call(Weather weather) {
//                        Log.e("weather",weather.getData().getGanmao());
//                    }
//                });
        subscriber = new Subscriber<MovieInfo>() {
            @Override
            public void onCompleted() {
               Log.e("info","隐藏对话框");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieInfo movieInfo) {
              Log.e("info","显示对话框");
                Log.e("info",movieInfo.getCount()+"");
            }
        };

        subscriber1 = new Subscriber<MovieInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieInfo movieInfo) {

            }
        };
        getMovie(0,10);
    }


    private void getMovie(int start,int count){
        MovieService movieService = RetrofitClient.getInstance().create(MovieService.class);
        movieService.getMovie(start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber,subscriber1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        subscriber.unsubscribe();
    }

    //    public static Retrofit getRetrofit(String url){
//        return new Retrofit.Builder().baseUrl(url)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//    }
//
//
//    interface IWeather{
//       @GET("/weather_mini")
//        Observable<Weather> getWeather(@Query("city") String city);
//    }
//
//    public static final String url_weather = "http://wthrcdn.etouch.cn";
//
//    public static IWeather getIWeather() {
//        return getRetrofit(url_weather).create(IWeather.class);
//    }

}

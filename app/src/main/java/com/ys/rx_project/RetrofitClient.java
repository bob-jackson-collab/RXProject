package com.ys.rx_project;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/9/7.
 */
public class RetrofitClient {

    private Retrofit mRetrofit;


    private static final RetrofitClient retrofitClient = new RetrofitClient();

    public static RetrofitClient getInstance(){
        return retrofitClient;
    }

    public RetrofitClient(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> tClass){
        return mRetrofit.create(tClass);
    }

}

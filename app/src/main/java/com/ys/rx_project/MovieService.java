package com.ys.rx_project;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface MovieService {

    @GET("top250")
    Observable<MovieInfo> getMovie(@Query("start") int start,@Query("count") int count);
}

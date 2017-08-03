package com.wordpress.aliqornanblog.myblogpost.api;

/**
 * Created by qornanali on 8/2/17.
 */

import com.wordpress.aliqornanblog.myblogpost.model.Result;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("posts")
    Observable<Result> getBlogPosts(@Query("number") int number);

}

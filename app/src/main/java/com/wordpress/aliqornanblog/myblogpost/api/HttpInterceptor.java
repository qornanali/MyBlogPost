package com.wordpress.aliqornanblog.myblogpost.api;

/**
 * Created by qornanali on 8/2/17.
 */

import android.util.Log;

import com.wordpress.aliqornanblog.myblogpost.util.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain pChain) throws IOException {
        Request original = pChain.request();

        Request request = original;
        long t1 = System.nanoTime();
        Logger.log(Log.INFO, String.format("Sending request %s on %s%n%s",
                request.url(), pChain.connection(), request.headers()));

        Response response = pChain.proceed(request);
        long t2 = System.nanoTime();

        Logger.log(Log.INFO, String.format("Received response for %s in %.1fms%n%s %s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers(), response.toString()));

        return response;
    }
}

package com.wordpress.aliqornanblog.myblogpost.api;

/**
 * Created by qornanali on 8/2/17.
 */

import retrofit2.HttpException;
import rx.Subscriber;


public abstract class RequestCallback<M> extends Subscriber<M> {

    public abstract void onRequestSuccess(M model);
    public abstract void onRequestFailure(String message);
    public abstract void onRequestCompleted();

    @Override
    public void onCompleted() {
        onRequestCompleted();
    }

    @Override
    public void onError(Throwable e) {
        String message = e.getMessage();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            message = httpException.getMessage();
        }
        onRequestFailure(message);
        onRequestCompleted();
    }

    @Override
    public void onNext(M m) {
        onRequestSuccess(m);
        onRequestCompleted();
    }
}

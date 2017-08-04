package com.wordpress.aliqornanblog.myblogpost.base;

/**
 * Created by qornanali on 8/1/17.
 */

import com.wordpress.aliqornanblog.myblogpost.api.RestApi;
import com.wordpress.aliqornanblog.myblogpost.api.NetworkClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public class BasePresenter<V extends BaseView> {

    protected V view;
    protected RestApi restApi;
    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;

    public void attachView(V view){
        this.view = view;
        restApi = NetworkClient.getRetrofit().create(RestApi.class);
    }

    public void dettachView(){
        view = null;
        if(compositeSubscription != null
                && compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }

    protected void onSubscribe(Observable observable, Subscriber subscriber){
        this.subscriber = subscriber;

        if(compositeSubscription == null){
            compositeSubscription = new CompositeSubscription();
        }

        compositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    protected void unSubscribe(){
        if(subscriber != null){
            subscriber.unsubscribe();
        }
    }
}

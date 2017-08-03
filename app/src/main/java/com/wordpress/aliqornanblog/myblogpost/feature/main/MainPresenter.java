package com.wordpress.aliqornanblog.myblogpost.feature.main;

/**
 * Created by qornanali on 8/2/17.
 */

import android.support.design.widget.Snackbar;

import com.wordpress.aliqornanblog.myblogpost.R;
import com.wordpress.aliqornanblog.myblogpost.api.RequestCallback;
import com.wordpress.aliqornanblog.myblogpost.base.BasePresenter;
import com.wordpress.aliqornanblog.myblogpost.model.Result;



public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        super.attachView(view);
    }

    public void getBlogPosts(){
        view.showProgressDialog(view.getContext().getString(R.string.message_loading_data), false);
        onSubscribe(apiService.getBlogPosts(5),
                new RequestCallback<Result>() {
                    @Override
                    public void onRequestSuccess(Result model) {
                        view.onSuccess(model);
                    }

                    @Override
                    public void onRequestFailure(String message) {
                        view.onError(message);
                        view.showSnackBar(message, Snackbar.LENGTH_LONG);
                    }

                    @Override
                    public void onRequestCompleted() {
                        view.dismissProgressDialog();
                    }
                });
    }

}

package com.wordpress.aliqornanblog.myblogpost.feature.main;

/**
 * Created by qornanali on 8/2/17.
 */

import android.content.Intent;
import android.net.Uri;
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
        onSubscribe(restApi.getBlogPosts(5),
                new RequestCallback<Result>() {
                    @Override
                    public void onRequestSuccess(Result model) {
                        if(model != null){
                            if(model.getPosts() != null){
                                if(model.getPosts().size() > 0){
                                    view.showDataListIntoRecyclerView(model.getPosts());
                                }else{
                                    view.showDataIsEmpty();
                                }
                            }else{
                                view.showErrorWhenGetData();
                            }
                        }else{
                            view.showErrorWhenGetData();
                        }
                    }

                    @Override
                    public void onRequestFailure(String message) {
                        view.showSnackBar(message, Snackbar.LENGTH_LONG);
                        view.showErrorWhenGetData();
                    }

                    @Override
                    public void onRequestCompleted() {
                        view.dismissProgressDialog();
                    }
                });
    }

    public void openUrlIntoBrowser(String url){
        if(!url.equals("")){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            view.getContext().startActivity(i);
        }
    }

}

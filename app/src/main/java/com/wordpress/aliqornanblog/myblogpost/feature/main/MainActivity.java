package com.wordpress.aliqornanblog.myblogpost.feature.main;

/**
 * Created by qornanali on 8/1/17.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wordpress.aliqornanblog.myblogpost.R;
import com.wordpress.aliqornanblog.myblogpost.adapter.BlogPostsAdapter;
import com.wordpress.aliqornanblog.myblogpost.model.Result;
import com.wordpress.aliqornanblog.myblogpost.mvp.MvpActivity;
import com.wordpress.aliqornanblog.myblogpost.util.Logger;

import butterknife.BindView;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView{

    @BindView(R.id.rv_list_blog_post)
    RecyclerView rvListBlogPost;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initialize() {
        setActionBarTitle(getString(R.string.app_name));
        rvListBlogPost.setLayoutManager(new LinearLayoutManager(this));
        presenter.getBlogPosts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSuccess(Result model) {
        rvListBlogPost.setAdapter(new BlogPostsAdapter(model.getPosts(), this) {
            @Override
            public void onReadMoreClick(String url) {
                onListItemReadMoreClick(url);
            }
        });
    }

    @Override
    public void onError(String errorMessage) {
        Logger.log(Log.ERROR, errorMessage);
        showSnackBar(errorMessage, Snackbar.LENGTH_LONG);
    }

    @Override
    public void onListItemReadMoreClick(String url) {
        if(!url.equals("")){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }
}

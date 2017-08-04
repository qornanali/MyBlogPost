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
import android.view.View;
import android.widget.TextView;

import com.wordpress.aliqornanblog.myblogpost.R;
import com.wordpress.aliqornanblog.myblogpost.adapter.BlogPostsAdapter;
import com.wordpress.aliqornanblog.myblogpost.model.BlogPost;
import com.wordpress.aliqornanblog.myblogpost.model.Result;
import com.wordpress.aliqornanblog.myblogpost.mvp.MvpActivity;
import com.wordpress.aliqornanblog.myblogpost.util.Logger;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView{

    @BindView(R.id.rv_list_blog_post)
    RecyclerView rvListBlogPost;
    @BindView(R.id.tv_message)
    TextView tvMessage;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initialize() {
        setActionBarTitle(getString(R.string.app_name));
        rvListBlogPost.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.getBlogPosts();
    }


    @Override
    public void showDataListIntoRecyclerView(List<BlogPost> blogPostList) {
        rvListBlogPost.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
        rvListBlogPost.setAdapter(new BlogPostsAdapter(blogPostList, this) {
            @Override
            public void onReadMoreClick(String url) {
                presenter.openUrlIntoBrowser(url);
            }
        });
    }

    @Override
    public void showDataIsEmpty() {
        rvListBlogPost.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(getString(R.string.message_no_data));
    }

    @Override
    public void showErrorWhenGetData() {
        rvListBlogPost.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(getString(R.string.message_no_data));
    }
}

package com.wordpress.aliqornanblog.myblogpost.feature.main;

/**
 * Created by qornanali on 8/2/17.
 */

import com.wordpress.aliqornanblog.myblogpost.base.BaseView;
import com.wordpress.aliqornanblog.myblogpost.model.BlogPost;
import com.wordpress.aliqornanblog.myblogpost.model.Result;

import java.util.List;


public interface MainView extends BaseView{

    void showDataListIntoRecyclerView(List<BlogPost> blogPostList);
    void showDataIsEmpty();
    void showErrorWhenGetData();

}

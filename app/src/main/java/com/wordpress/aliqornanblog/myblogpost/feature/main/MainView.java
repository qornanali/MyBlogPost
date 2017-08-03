package com.wordpress.aliqornanblog.myblogpost.feature.main;

/**
 * Created by qornanali on 8/2/17.
 */

import com.wordpress.aliqornanblog.myblogpost.base.BaseView;
import com.wordpress.aliqornanblog.myblogpost.model.Result;


public interface MainView extends BaseView<Result>{

    void onListItemReadMoreClick(String url);

}

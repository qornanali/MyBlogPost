package com.wordpress.aliqornanblog.myblogpost.mvp;

/**
 * Created by qornanali on 8/2/17.
 */

import android.support.annotation.LayoutRes;

import com.wordpress.aliqornanblog.myblogpost.base.BaseActivity;
import com.wordpress.aliqornanblog.myblogpost.base.BasePresenter;


public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected  P presenter;

    protected abstract P initPresenter();

    protected abstract void initialize();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        presenter = initPresenter();
        initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.dettachView();
    }

}

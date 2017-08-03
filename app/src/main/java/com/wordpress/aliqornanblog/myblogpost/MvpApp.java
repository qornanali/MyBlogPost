package com.wordpress.aliqornanblog.myblogpost;

/**
 * Created by qornanali on 8/1/17.
 */

import android.app.Application;
import android.content.Context;

public class MvpApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}

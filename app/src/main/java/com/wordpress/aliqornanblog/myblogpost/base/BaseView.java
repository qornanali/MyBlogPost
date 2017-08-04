package com.wordpress.aliqornanblog.myblogpost.base;

/**
 * Created by qornanali on 8/1/17.
 */

import android.content.Context;
import android.os.Bundle;
import android.view.View;


public interface BaseView {

    Context getContext();

    void showSnackBar(String message, int duration);

    void showToast(String message, int duration);

    void showProgressDialog(String message, boolean cancelable);

    void dismissProgressDialog();

    void displayHome();

    void setActionBarTitle(String title);

    void onNavigationClick(View view);

    void goToActivity(Class c, Bundle bundle, boolean isFinish);

    void goToActivityClearAllStack(Class c, Bundle bundle);

    void goToActivityForResult(Class c, Bundle bundle, int result);

    void finishActivityforResult(Bundle bundle, int result);

}

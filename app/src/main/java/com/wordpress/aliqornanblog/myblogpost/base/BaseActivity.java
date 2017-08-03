package com.wordpress.aliqornanblog.myblogpost.base;

/**
 * Created by qornanali on 8/1/17.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.wordpress.aliqornanblog.myblogpost.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNavigationClick(view);
                }
            });
        }
    }

    public Context getContext() {
        return this;
    }

    protected View getRootView() {
        return findViewById(android.R.id.content);
    }
    public void showToast(String message, int duration){
        Toast.makeText(this, message, duration).show();
    }

    public void showSnackBar(String message, int duration){
        Snackbar.make(getRootView(), message, duration).show();
    }

    public void showProgressDialog(String message, boolean cancelable){
        progressDialog.setMessage(message);
        progressDialog.setCancelable(cancelable);
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    public void dismissProgressDialog(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    public void displayHome(){
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void setActionBarTitle(String title){
        if(actionBar != null) actionBar.setTitle(title);
    }

    public void onNavigationClick(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void goToActivity(Class c, Bundle bundle, boolean isFinish){
        Intent i = new Intent(this, c);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivity(i);
        if (isFinish) {
            finish();
        }
    }

    public void goToActivityClearAllStack(Class c, Bundle bundle){
        Intent i = new Intent(this, c);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }

    public void goToActivityForResult(Class c, Bundle bundle, int result){
        Intent i = new Intent(this, c);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivityForResult(i, result);
    }

    public void finishActivityforResult(Bundle bundle, int result){
        Intent i = new Intent();
        if (bundle != null) {
            i.putExtras(bundle);
        }
        setResult(result, i);
        finish();
    }


}

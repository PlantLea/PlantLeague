package com.team.baseapp.baseapp;

import android.app.Application;

import java.util.logging.Logger;

/**
 * 自定义的application, 一般不用管这个东西
 * Created by lynnzc on 16-3-15.
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //init here
        if (BuildConfig.DEBUG) {
            //Debug 过程调用

        }
    }
}

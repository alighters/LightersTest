package com.lighters.demo.app;

import android.app.Application;
import android.content.Context;

import com.lighters.demo.BuildConfig;
import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by david on 15/12/17.
 */
public class BaseApplication extends Application {


    private static Context mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Logger.init("lighters.demo")                 // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                    .methodOffset(2)                // default 0
                    .logTool(new AndroidLogTool()); // custom log tool, optional


            LeakCanary.install(this);
        }

        mApp = this;
    }

    public static Context getApp() {
        return mApp;
    }
}

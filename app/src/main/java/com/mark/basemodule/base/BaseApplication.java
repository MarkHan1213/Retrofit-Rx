package com.mark.basemodule.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Mark.Han on 2017/7/10.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}

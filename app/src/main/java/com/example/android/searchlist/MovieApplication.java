package com.example.android.searchlist;

import android.app.Application;
import android.util.Log;

public class MovieApplication extends Application {
    private static final String LOG_TAG = "AppStart";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LOG_TAG,"This is first statement on app executing");
        AppInstanceUtil.setInstance(this);
    }
}
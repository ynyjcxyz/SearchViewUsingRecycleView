package com.example.android.searchlist;

import android.app.Application;

public class MovieApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    AppInstanceUtil.setInstance(this);
  }
}
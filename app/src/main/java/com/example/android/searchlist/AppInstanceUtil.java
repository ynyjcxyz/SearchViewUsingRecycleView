package com.example.android.searchlist;

import android.app.Application;

/**
 * Because Application is a singleton, hence it is relatively okay to have a static reference here.
 * This is helpful to avoid passing the application around the whole code base.
 */
public class AppInstanceUtil {

 private static Application instance;

  public static Application get() {
    return instance;
  }

  public static void setInstance(Application instance) {
    AppInstanceUtil.instance = instance;
  }
}
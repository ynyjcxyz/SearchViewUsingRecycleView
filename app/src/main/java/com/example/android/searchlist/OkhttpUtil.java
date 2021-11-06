package com.example.android.searchlist;

import android.app.Application;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class OkhttpUtil {

  public static OkHttpClient get(Application application) {
      return new OkHttpClient.Builder().addInterceptor(
          new ChuckerInterceptor.Builder(application).build()
      ).build();
  }
}
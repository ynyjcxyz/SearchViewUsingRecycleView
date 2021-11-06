package com.example.android.searchlist;

import android.app.Application;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitUtil {

  public static Retrofit get(Application application) {
    return new Retrofit.Builder()
        .client(customized(application))
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonUtil.factory())
            .build();
  }

  public static OkHttpClient customized(Application application) {
      return new OkHttpClient.Builder().addInterceptor(
          new ChuckerInterceptor.Builder(application).build()
      ).build();
  }
}
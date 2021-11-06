package com.example.android.searchlist;

import android.app.Application;
import retrofit2.Retrofit;

public class RetrofitUtil {

  public static Retrofit get(Application application) {
    return new Retrofit.Builder()
        .client(OkhttpUtil.get(application))
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonUtil.factory())
            .build();
  }

}
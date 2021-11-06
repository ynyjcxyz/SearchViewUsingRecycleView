package com.example.android.searchlist;

import retrofit2.Retrofit;

public class RetrofitUtil {

  public static Retrofit get() {
    return new Retrofit.Builder()
        .client(OkhttpUtil.get())
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonUtil.factory())
            .build();
  }

}
package com.example.android.searchlist;

import android.app.Application;
import retrofit2.Retrofit;

public class RetrofitUtil {
    public static Retrofit get(){
        return new Retrofit
                .Builder()
                .client(OkhttpUtil.get())
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonUtil.factory())
                .build();
    }

//    private static OkHttpClient customizedClient(Application application) {
//        return new OkHttpClient
//                .Builder()
//                .addInterceptor
//                        (new ChuckerInterceptor
//                                .Builder(application)
//                                .build())
//                .build();
//    }
}

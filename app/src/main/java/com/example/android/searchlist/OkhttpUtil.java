package com.example.android.searchlist;

import android.app.Application;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import okhttp3.OkHttpClient;

public class OkhttpUtil {
    public static OkHttpClient get(){
        return new OkHttpClient
                .Builder()
                .addInterceptor
                        (new ChuckerInterceptor
                                .Builder(AppInstanceUtil.get())
                                .build())
                .build();
    }
}

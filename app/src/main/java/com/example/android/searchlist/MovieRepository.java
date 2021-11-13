package com.example.android.searchlist;

import android.app.Application;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.io.IOException;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** Move fetchMovieDto method to RetrofitUtil class*/

public class MovieRepository {
    public static MovieDto fetchMovieDto(String apiKey) throws IOException{
//        Gson enhancedGson = new GsonBuilder()
//                .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
//                .create();
//        GsonConverterFactory factory = GsonConverterFactory.create(GsonProvider.get());

//        Retrofit retrofit = new Retrofit
//                .Builder()
//                .client(customizedClient(application))
//                .baseUrl("https://api.themoviedb.org/3/")
//                .addConverterFactory(GsonUtil.factory())
//                .build();
        Retrofit retrofit = RetrofitUtil.get();
        MovieService service = retrofit.create(MovieService.class);

        return service.listRepos(apiKey).execute().body();
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
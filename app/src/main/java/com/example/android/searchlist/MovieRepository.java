package com.example.android.searchlist;

import android.app.Application;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {
    public static MovieDto fetchMovieDto(String apiKey, Application application) throws IOException{
        Gson enhancedGson = GsonProvider.get();
        GsonConverterFactory factory = GsonConverterFactory.create(enhancedGson);

        Retrofit retrofit = new Retrofit.Builder()
            .client(customized(application))
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(factory)
                .build();
        MovieService service = retrofit.create(MovieService.class);

        return service.listRepos(apiKey).execute().body();
    }

    private static OkHttpClient customized(Application application) {
        return new OkHttpClient.Builder().addInterceptor(
            new ChuckerInterceptor.Builder(application).build()
        ).build();
    }
}
package com.example.android.searchlist;

import android.app.Application;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import java.io.IOException;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MovieRepository {
    public static MovieDto fetchMovieDto(String apiKey, Application application) throws IOException{

        Retrofit retrofit = new Retrofit.Builder()
            .client(customized(application))
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonUtil.factory())
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
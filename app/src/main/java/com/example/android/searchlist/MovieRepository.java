package com.example.android.searchlist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.io.IOException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {
    public static MovieDto fetchMovieDto(String apiKey) throws IOException{
        Gson enhancedGson = new GsonBuilder()
                .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
                .create();
        GsonConverterFactory factory = GsonConverterFactory.create(enhancedGson);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(factory)
                .build();
        MovieService service = retrofit.create(MovieService.class);

        return service.listRepos(apiKey).execute().body();
    }
}
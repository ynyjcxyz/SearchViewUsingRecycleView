package com.example.android.searchlist;

import android.app.Application;
import java.io.IOException;
import retrofit2.Retrofit;

public class MovieRepository {

  public static MovieDto fetchMovieDto(String apiKey, Application application) throws IOException {
    Retrofit retrofit = RetrofitUtil.get(application);
    MovieService service = retrofit.create(MovieService.class);
    return service.listRepos(apiKey).execute().body();
  }

}
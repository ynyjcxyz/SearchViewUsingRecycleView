package com.example.android.searchlist;

import java.io.IOException;
import retrofit2.Retrofit;

public class MovieRepository {

  public static MovieDto fetchMovieDto(String apiKey) throws IOException {
    Retrofit retrofit = RetrofitUtil.get();
    MovieService service = retrofit.create(MovieService.class);
    return service.listRepos(apiKey).execute().body();
  }

}
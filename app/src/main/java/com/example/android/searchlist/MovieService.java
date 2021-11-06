package com.example.android.searchlist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("discover/movie")
    Call<MovieDto> listRepos(@Query("api_key") String apiKey);
}
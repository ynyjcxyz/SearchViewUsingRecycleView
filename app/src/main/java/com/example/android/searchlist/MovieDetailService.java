package com.example.android.searchlist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDetailService {
    @GET("movie/{movie_id}")
    Call<MovieDetailDto> listReposDetail(@Path("movie_id") String movieId,
                                         @Query("api_key") String apiKey);
}
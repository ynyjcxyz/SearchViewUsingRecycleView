package com.example.android.searchlist;

import java.io.IOException;

import retrofit2.Retrofit;

public class MovieDetailRepository {
    public static MovieDetailDto fetchMovieDetailDto(String movieId,String apiKey) throws IOException {
        Retrofit retrofitDetail = RetrofitUtil.get();
        MovieDetailService detailService = retrofitDetail.create(MovieDetailService.class);
        return detailService.listReposDetail(movieId,apiKey).execute().body();
    }
}
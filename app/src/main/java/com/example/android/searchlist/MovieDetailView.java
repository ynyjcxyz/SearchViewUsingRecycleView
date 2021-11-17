package com.example.android.searchlist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailView extends AppCompatActivity {
    private static final String API_KEY =
            "f16105c3c8be65f8d91bf05a968202f1";
    
    TextView main_title = findViewById(R.id.main_title);
    TextView main_original_title = findViewById(R.id.main_original_title);
    ImageView poster_img = findViewById(R.id.poster_img);
    TextView overview = findViewById(R.id.overview);
    TextView country = findViewById(R.id.country);
    TextView vote_average = findViewById(R.id.vote_average);
    TextView vote_count = findViewById(R.id.vote_count);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Intent intent = getIntent();
        String MOVIE_ID = intent.getStringExtra("MovieId");
        getMovieDto(MOVIE_ID,API_KEY);

        main_title.setText(API_KEY + MOVIE_ID);
    }

    private MovieDto getMovieDto(String movieId, String apiKey) {
        return null;
    }
}

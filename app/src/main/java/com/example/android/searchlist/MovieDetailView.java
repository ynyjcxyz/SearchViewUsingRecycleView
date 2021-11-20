package com.example.android.searchlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.Locale;

import retrofit2.Call;

public class MovieDetailView extends AppCompatActivity {
    private static final String API_KEY =
            "f16105c3c8be65f8d91bf05a968202f1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        TextView main_title = findViewById(R.id.main_title);
        TextView main_original_title = findViewById(R.id.main_original_title);
        ImageView poster_img = findViewById(R.id.poster_img);
        TextView overview = findViewById(R.id.overview);
        TextView country = findViewById(R.id.country);
        TextView vote_average = findViewById(R.id.vote_average);
        TextView vote_count = findViewById(R.id.vote_count);

        String title = getIntent().getStringExtra("title");
        String original_title = getIntent().getStringExtra("original_title");
        String poster_path = getIntent().getStringExtra("poster_path");
        String overviewText = getIntent().getStringExtra("overview");
        String original_language = getIntent().getStringExtra("original_language");
        String vote_averageText = getIntent().getStringExtra("vote_average");
        String vote_countText = getIntent().getStringExtra("vote_count");

        main_title.setText(title);
        main_original_title.setText("Original Title: " + original_title);

        Glide.with(MovieDetailView.this)
                .load("https://image.tmdb.org/t/p/w500" + poster_path)
                .error(R.drawable.no_data)
                .into(poster_img);

        overview.setText("Overview: " + overviewText);
        country.setText("Original Language: " + original_language.toUpperCase(Locale.ROOT));
        vote_average.setText("Average Vote: " + vote_averageText + "/10");
        vote_count.setText("Vote Count: " + vote_countText);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.android.searchlist;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.io.IOException;
import java.util.List;

public class ListLoader extends AsyncTaskLoader<List<Item>> {
    public static final String LOG_TAG = AsyncTaskLoader.class.getSimpleName();
    private final String query;

    public ListLoader(@NonNull Context context, String apiKey) {
        super(context);
        query = apiKey;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"This is onStartLoading() method");
        forceLoad();
    }

    @Nullable
    @Override
    public List<Item> loadInBackground() {
        Log.i(LOG_TAG,"This is loadInBackground() method");
        try{
            return MovieRepository.fetchMovieDto(query).ItemsList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

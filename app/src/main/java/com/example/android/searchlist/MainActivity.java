package com.example.android.searchlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Item>> {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String API_KEY =
            "f16105c3c8be65f8d91bf05a968202f1";
    private static final int DATA_LOADER_ID = 1;
    private final List<Item> items = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Log.i(LOG_TAG, "This is initLoader()");
        LoaderManager.getInstance(this)
                .initLoader(DATA_LOADER_ID, null, this).forceLoad();
    }

    @NonNull
    @Override
    public Loader<List<Item>> onCreateLoader(int id, @Nullable Bundle args) {
        Log.i(LOG_TAG, "This is onCreateLoader() callback");
        return new ListLoader(this, API_KEY);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Item>> loader, List<Item> data) {
        Log.i(LOG_TAG, "This is onLoadFinished() callback");

        mAdapter = new ItemAdapter(MainActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);

        items.addAll(data);
        Log.i(LOG_TAG, "Items: " + items.toString());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main_activity, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) getApplicationContext()
                .getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView
                    .setSearchableInfo
                            (searchManager
                                    .getSearchableInfo
                                            (MainActivity.this.getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {
                    List<Item> newList = new ArrayList<>();
                    for (Item item : items) {
                        if (Objects
                                .requireNonNull(item.original_title())
                                .toLowerCase()
                                .contains(newText.toLowerCase())
                                || Objects
                                .requireNonNull(item.title())
                                .toLowerCase()
                                .contains(newText.toLowerCase())
                        ) {
                            newList.add(item);
                        }
                    }
                    mAdapter = new ItemAdapter(MainActivity.this, newList);
                    mRecyclerView.setAdapter(mAdapter);
                    return true;
                }

                @Override
                public boolean onQueryTextSubmit(String query) {
                    return true;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {
        Log.i(LOG_TAG, "This is onLoaderReset method");
        loader.reset();
        items.clear();
        mRecyclerView.removeAllViews();
        mLayoutManager.removeAllViews();
    }
}
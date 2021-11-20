package com.example.android.searchlist;

import androidx.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
public abstract class Item {
    @Nullable
    @SerializedName("backdrop_path")
    abstract String backdrop_path();

    @Nullable
    @SerializedName("id")
    abstract Integer id();

    @Nullable
    @SerializedName("original_language")
    abstract String original_language();

    @Nullable
    @SerializedName("original_title")
    abstract String original_title();

    @Nullable
    @SerializedName("overview")
    abstract String overview();

    @Nullable
    @SerializedName("poster_path")
    abstract String poster_path();

    @Nullable
    @SerializedName("release_date")
    abstract String release_date();

    @Nullable
    @SerializedName("title")
    abstract String title();

    @Nullable
    @SerializedName("vote_average")
    abstract String vote_average();

    @Nullable
    @SerializedName("vote_count")
    abstract String vote_count();

    public static Item create(String backdrop_path, Integer id, String original_language,
                              String original_title, String overview, String poster_path,
                              String release_date, String title, String vote_average,
                              String vote_count) {
        return new AutoValue_Item(backdrop_path, id, original_language,
                original_title, overview, poster_path,
                release_date, title, vote_average, vote_count);
    }
}
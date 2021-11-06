package com.example.android.searchlist;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

import java.util.List;

@AutoValue
public abstract class MovieDto {
    @SerializedName("page")
    public abstract int page();

    @SerializedName("results")
    public abstract List<Item> ItemsList();

    @SerializedName("total_pages")
    public abstract int total_pages();

    @SerializedName("total_results")
    public abstract int total_results();

    public static MovieDto create(int page , List<Item> ItemsList , int total_pages , int total_results){
        return new AutoValue_MovieDto(page , ItemsList , total_pages , total_results);
    }
}
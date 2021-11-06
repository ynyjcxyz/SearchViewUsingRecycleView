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
    @SerializedName("release_date")
    abstract String release_date();

    @Nullable
    @SerializedName("title")
    abstract String title();

    public static Item create(String backdrop_path , Integer id , String original_language , String original_title , String release_date , String title){
        return new AutoValue_Item(backdrop_path, id , original_language , original_title , release_date , title);
    }
}
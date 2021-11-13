package com.example.android.searchlist;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
public abstract class MiniEntity {

    @SerializedName("id")
    abstract Integer id();

    @SerializedName("name")
    abstract String name();

    public static MiniEntity create(Integer id, String name) {
        return new AutoValue_MiniEntity(id, name);
    }
}
package com.example.android.searchlist;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
public abstract class ProductionCountry {
    @SerializedName("iso_3166_1")
    public abstract String country_code();

    @SerializedName("name")
    public abstract String country_name();
}
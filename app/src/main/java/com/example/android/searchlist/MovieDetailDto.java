package com.example.android.searchlist;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class MovieDetailDto {
    @SerializedName("original_language")
    public abstract String original_language();

    @SerializedName("original_title")
    public abstract String original_title();

    @SerializedName("overview")
    public abstract String overview();

    @SerializedName("poster_path")
    public abstract String poster_path();

    @SerializedName("production_countries")
    public abstract List<ProductionCountry> production_countries();

    @SerializedName("title")
    public abstract String detail_title();

    @SerializedName("vote_average")
    public abstract String vote_average();

    @SerializedName("vote_count")
    public abstract String vote_count();

    public static MovieDetailDto create
            (String original_language,String original_title,String overview,String poster_path,
             List<ProductionCountry> production_countries,String detail_title,String vote_average,
             String vote_count){
        return new AutoValue_MovieDetailDto(original_language,original_title,overview,poster_path,
                production_countries,detail_title,vote_average,vote_count);
    }
}

package com.example.android.searchlist;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.Collections;
import java.util.List;

@GenerateTypeAdapter
@AutoValue
public abstract class MiniEntity {

  @SerializedName("id")
  abstract List<String> id();

  @SerializedName("name")
  abstract String name();

  public static MiniEntity create(Integer id, String name) {
    return new AutoValue_MiniEntity(Collections.emptyList(), name);
  }

}
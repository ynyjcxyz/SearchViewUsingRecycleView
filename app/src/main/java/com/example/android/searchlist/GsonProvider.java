package com.example.android.searchlist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

public class GsonProvider {

  public static Gson get() {
      Gson enhancedGson = new GsonBuilder()
              .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
              .create();
      return enhancedGson;
  }
}
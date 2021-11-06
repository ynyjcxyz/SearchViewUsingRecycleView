package com.example.android.searchlist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import retrofit2.converter.gson.GsonConverterFactory;

public class GsonUtil {

  public static Gson get() {
      Gson enhancedGson = new GsonBuilder()
              .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
              .create();
      return enhancedGson;
  }

  public static GsonConverterFactory factory() {
      Gson enhancedGson = get();
      GsonConverterFactory factory = GsonConverterFactory.create(enhancedGson);
      return factory;
  }
}
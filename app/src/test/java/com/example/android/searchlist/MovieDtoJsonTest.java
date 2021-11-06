package com.example.android.searchlist;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import org.junit.Test;
import util.TestUtil;


public class MovieDtoJsonTest {


  @Test
  public void testReadJsonFile() {

    String jsonContent = TestUtil.content("mini.json", this);
    MiniEntity actual = transformToEntity(jsonContent);

    Truth.assertThat(actual).isNotNull();
  }

  private MiniEntity transformToEntity(String jsonContent) {
    Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
        .create();
    return gson.fromJson(jsonContent,MiniEntity.class);
   }

}
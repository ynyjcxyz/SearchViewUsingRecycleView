package com.example.android.searchlist;

import static com.google.common.truth.Truth.assertThat;
import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import org.junit.Test;
import util.TestUtil;

public class MovieDtoJsonTest {
    @Test
    public void testReadJsonFile(){
        String jsonContent = TestUtil.content("movie.json" , this);
        MovieDto actual = transformToEntity(jsonContent);

//        Truth.assertThat(actual).isNotNull();
        System.out.println(actual.toString());
        assertThat(actual).isNotNull();
        assertThat(actual.page()).isEqualTo(1);
        assertThat(actual.total_pages()).isEqualTo(500);
        assertThat(actual.total_results()).isEqualTo(10000);
        assertThat(actual.ItemsList()).hasSize(20);
        assertThat(actual.ItemsList().get(17).title()).contains("Slayer");
    }

    private MovieDto transformToEntity(String jsonContent) {
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapterFactory(GenerateTypeAdapter.FACTORY)
//                .create();
        Gson gson = GsonUtil.get();
        return gson.fromJson(jsonContent,MovieDto.class);
    }
}
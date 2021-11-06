package com.example.android.searchlist;

import com.google.common.truth.Truth;
import org.junit.Test;


public class MiniEntityTest {


  @Test
  public void testReadJsonFile() {
    MiniEntity tony1 = MiniEntity.create(1, "tony");
    Truth.assertThat(tony1).isNotNull();

    MiniEntity tony2 = MiniEntity.create(1, "tony");
    Truth.assertThat(tony2).isNotNull();

    Truth.assertThat(tony1).isEqualTo(tony2);
  }

}
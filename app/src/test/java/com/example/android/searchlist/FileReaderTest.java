package com.example.android.searchlist;

import com.google.common.truth.Truth;
import org.junit.Test;
import util.TestUtil;


public class FileReaderTest {

  private static final String JSON_EXAMPLE = "{\n"
      + "  \"id\": 1,\n"
      + "  \"name\": \"Tony\"\n"
      + "}";

  @Test
  public void testReadJsonFile() {

    String jsonContent = TestUtil.content("mini.json", this);
    System.out.println(jsonContent);
    Truth.assertThat(jsonContent).isEqualTo(JSON_EXAMPLE);
  }


  @Test
  public void testReadTxtFile() {

    String txtContent = TestUtil.content("1.txt", this);
    Truth.assertThat(txtContent).isEqualTo("123");

  }
}
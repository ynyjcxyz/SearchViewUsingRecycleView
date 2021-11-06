package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.io.FileUtils;

public class TestUtil {

  public static File file(String fileName, Object obj) {
    ClassLoader classLoader = obj.getClass().getClassLoader();
    assert classLoader != null;
    URL resource = classLoader.getResource(fileName);
    assert resource != null;
    return new File(resource.getPath());
  }

  public static String content(String filePath, Object obj) {
    return content(filePath, "UTF-8", obj);
  }

  public static String content(String filePath, String encoding, Object obj) {
    try {
      return FileUtils.readFileToString(file(filePath, obj), encoding);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static InputStream inputStream(String fileName, Object obj) {
    try {
      return new FileInputStream(file(fileName, obj));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
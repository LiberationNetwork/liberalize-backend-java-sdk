package liberalize.java.backend.sdk.utils;

import java.util.Base64;

public class StringUtil {
  public static String toBase64(String input) {
    byte[] encoded = Base64.getEncoder().encode(input.getBytes());
    return new String(encoded);
  }
}

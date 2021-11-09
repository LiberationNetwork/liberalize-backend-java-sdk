package liberalize.java.backend.sdk.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

public class StringUtil {
  public static String toBase64(String input) {
    byte[] encoded = Base64.encodeBase64(input.getBytes(StandardCharsets.UTF_8));
    return new String(encoded);
  }
}

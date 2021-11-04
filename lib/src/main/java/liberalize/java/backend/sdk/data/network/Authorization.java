package liberalize.java.backend.sdk.data.network;

import liberalize.java.backend.sdk.utils.StringUtil;

public class Authorization {

  private final String key;

  public Authorization(String key) {
    this.key = StringUtil.toBase64(key + ":");
  }

  public String value() {
    return key;
  }
}

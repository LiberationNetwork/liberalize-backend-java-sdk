package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class AuthorizePaymentRequest {
  /** payment source */
  @SerializedName("source")
  public String source;

  public AuthorizePaymentRequest(String source) {
    if (source.startsWith("card")) {
      this.source = "lib:customer:paymentMethods/" + source;
    } else {
      this.source = source;
    }
  }
}

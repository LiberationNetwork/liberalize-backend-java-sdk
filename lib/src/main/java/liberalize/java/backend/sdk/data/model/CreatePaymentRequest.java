package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class CreatePaymentRequest {
  /** payment source */
  @SerializedName("source")
  public String source;
  /** amount as integer number */
  @SerializedName("amount")
  public int amount;
  /** should authorize payment after create or not; true if need to */
  @SerializedName("authorize")
  public boolean authorize;
  /** currency */
  @SerializedName("currency")
  public String currency;

  public CreatePaymentRequest(
    String source,
    int amount,
    boolean authorize,
    String currency) {

    if (source.startsWith("card")) {
      this.source = "lib:customer:paymentMethods/" + source;
    } else {
      this.source = source;
    }

    this.amount = amount;
    this.authorize = authorize;
    this.currency = currency;
  }
}

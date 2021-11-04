package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class RefundPaymentRequest {
  /** amount as integer */
  @SerializedName("amount")
  public int amount;

  public RefundPaymentRequest(int amount) {
    this.amount = amount;
  }
}

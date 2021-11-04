package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class CapturePaymentRequest {
  /** amount as integer */
  @SerializedName("amount")
  public int amount;

  public CapturePaymentRequest(int amount) {
    this.amount = amount;
  }
}

package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class Processor {
  @SerializedName("transactionId")
  public String transactionId;
  @SerializedName("qrData")
  public String qrData;
  @SerializedName("status")
  public String status;
  @SerializedName("authCode")
  public String authCode;

  public Processor(String transactionId, String qrData, String status, String authCode) {
    this.transactionId = transactionId;
    this.qrData = qrData;
    this.status = status;
    this.authCode = authCode;
  }
}

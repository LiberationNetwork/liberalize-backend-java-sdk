package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class Payment {
  @SerializedName("id")
  public String id;
  @SerializedName("organizationId")
  public String organizationId;
  @SerializedName("posId")
  public String posId;
  @SerializedName("accountId")
  public String accountId;
  @SerializedName("currency")
  public String currency;
  @SerializedName("amount")
  public Double amount;
  @SerializedName("amountCaptured")
  public Double amountCaptured;
  @SerializedName("state")
  public String state;
  @SerializedName("source")
  public String source;
  @SerializedName("routeId")
  public String routeId;
  @SerializedName("paymentMethod")
  public PaymentMethod paymentMethod;
  @SerializedName("authCode")
  public String authCode;
  @SerializedName("createdAt")
  public String createdAt;
  @SerializedName("updatedAt")
  public String updatedAt;

  public Payment(
    String id,
    String organizationId,
    String posId,
    String accountId,
    String currency,
    Double amount,
    Double amountCaptured,
    String state,
    String source,
    String routeId,
    PaymentMethod paymentMethod,
    String authCode,
    String createdAt,
    String updatedAt) {

    this.id = id;
    this.organizationId = organizationId;
    this.posId = posId;
    this.accountId = accountId;
    this.currency = currency;
    this.amount = amount;
    this.amountCaptured = amountCaptured;
    this.state = state;
    this.source = source;
    this.routeId = routeId;
    this.paymentMethod = paymentMethod;
    this.authCode = authCode;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}

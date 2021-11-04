package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class PaymentDetailsResponse {

  @SerializedName("id")
  public String id;
  @SerializedName("organizationId")
  public String organizationId;
  @SerializedName("posId")
  public String posId;
  @SerializedName("amountCaptured")
  public Double amountCaptured;
  @SerializedName("amountRefunded")
  public Double amountRefunded;
  @SerializedName("state")
  public String state;
  @SerializedName("source")
  public String source;
  @SerializedName("routeId")
  public String routeId;
  @SerializedName("amount")
  public Double amount;
  @SerializedName("currency")
  public String currency;
  @SerializedName("createdAt")
  public String createdAt;
  @SerializedName("updatedAt")
  public String updatedAt;
  @SerializedName("paymentMethod")
  public PaymentMethod paymentMethod;

  public PaymentDetailsResponse(
    String id,
    String organizationId,
    String posId,
    Double amountCaptured,
    Double amountRefunded,
    String state,
    String source,
    String routeId,
    Double amount,
    String currency,
    String createdAt,
    String updatedAt,
    PaymentMethod paymentMethod) {

    this.id = id;
    this.organizationId = organizationId;
    this.posId = posId;
    this.amountCaptured = amountCaptured;
    this.amountRefunded = amountRefunded;
    this.state = state;
    this.source = source;
    this.routeId = routeId;
    this.amount = amount;
    this.currency = currency;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.paymentMethod = paymentMethod;
  }
}

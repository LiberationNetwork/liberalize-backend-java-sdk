package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class PaymentFlowResponse {
  @SerializedName("id")
  public String id;
  @SerializedName("organizationId")
  public String organizationId;
  @SerializedName("posId")
  public String posId;
  @SerializedName("paymentId")
  public String paymentId;
  @SerializedName("payment")
  public Payment payment;
  @SerializedName("account")
  public Account account;
  @SerializedName("parentTransaction")
  public ParentTransaction parentTransaction;
  @SerializedName("processor")
  public Processor processor;
  @SerializedName("status")
  public String status;
  @SerializedName("amount")
  public Double amount;
  @SerializedName("currency")
  public String currency;
  @SerializedName("createdAt")
  public String createdAt;
  @SerializedName("updatedAt")
  public String updatedAt;

  public PaymentFlowResponse(String id,
    String organizationId,
    String posId,
    String paymentId,
    Payment payment,
    Account account,
    ParentTransaction parentTransaction,
    Processor processor, String status,
    Double amount,
    String currency,
    String createdAt,
    String updatedAt) {

    this.id = id;
    this.organizationId = organizationId;
    this.posId = posId;
    this.paymentId = paymentId;
    this.payment = payment;
    this.account = account;
    this.parentTransaction = parentTransaction;
    this.processor = processor;
    this.status = status;
    this.amount = amount;
    this.currency = currency;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}

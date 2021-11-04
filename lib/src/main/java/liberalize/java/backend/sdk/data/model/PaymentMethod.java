package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class PaymentMethod {
  @SerializedName("type")
  public String type;
  @SerializedName("id")
  public String id;
  @SerializedName("postType")
  public String postType;
  @SerializedName("card")
  public Card card;
  @SerializedName("sourceIp")
  public String sourceIp;

  public PaymentMethod(String type, String id, String postType, Card card, String sourceIp) {
    this.type = type;
    this.id = id;
    this.postType = postType;
    this.card = card;
    this.sourceIp = sourceIp;
  }
}

package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class Card {
  @SerializedName("name")
  public String name;
  @SerializedName("organizationId")
  public String organizationId;
  @SerializedName("data")
  public CardData data;
  @SerializedName("expiry")
  public CardExpiry expiry;

  public Card(String name, String organizationId, CardData data, CardExpiry expiry) {
    this.name = name;
    this.organizationId = organizationId;
    this.data = data;
    this.expiry = expiry;
  }
}

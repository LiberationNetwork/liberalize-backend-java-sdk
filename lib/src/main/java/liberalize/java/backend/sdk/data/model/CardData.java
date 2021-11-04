package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

class CardData {
  @SerializedName("scheme")
  public String scheme;
  @SerializedName("last4")
  public String last4;
  @SerializedName("iin")
  public String iin;

  public CardData(String scheme, String last4, String iin) {
    this.scheme = scheme;
    this.last4 = last4;
    this.iin = iin;
  }
}

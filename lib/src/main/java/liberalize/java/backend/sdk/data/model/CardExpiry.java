package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

class CardExpiry {
  @SerializedName("month")
  public String month;
  @SerializedName("year")
  public String year;

  public CardExpiry(String month, String year) {
    this.month = month;
    this.year = year;
  }
}

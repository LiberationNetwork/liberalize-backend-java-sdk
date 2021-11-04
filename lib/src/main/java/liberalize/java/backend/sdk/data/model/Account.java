package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class Account {
  @SerializedName("id")
  public String id;

  public Account(String id) {
    this.id = id;
  }
}

package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class ParentTransaction {
  @SerializedName("id")
  public String id;

  public ParentTransaction(String id) {
    this.id = id;
  }
}

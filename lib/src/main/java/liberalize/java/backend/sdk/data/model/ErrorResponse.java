package liberalize.java.backend.sdk.data.model;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
  @SerializedName("code")
  public String code;

  @SerializedName("message")
  public String message;

  public ErrorResponse(String code, String message) {
    this.code = code;
    this.message = message;
  }
}

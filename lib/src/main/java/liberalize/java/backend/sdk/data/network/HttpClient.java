package liberalize.java.backend.sdk.data.network;

import javax.annotation.Nullable;

import okhttp3.Headers;
import okhttp3.RequestBody;

interface HttpClient {
  void post(
    String path,
    Headers headers,
    @Nullable RequestBody body,
    ApiResponse apiResponse);

  void get(
    String path,
    Headers headers,
    ApiResponse apiResponse);

  void put(String path,
    Headers headers,
    @Nullable RequestBody body,
    ApiResponse apiResponse);
}

interface ApiResponse {
  void onSuccess(String body);
  void onError(String errorMessage);
}
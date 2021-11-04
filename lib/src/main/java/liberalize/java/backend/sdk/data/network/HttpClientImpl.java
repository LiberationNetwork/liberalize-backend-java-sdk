package liberalize.java.backend.sdk.data.network;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import liberalize.java.backend.sdk.LiberalizeBE;
import liberalize.java.backend.sdk.data.model.ErrorResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClientImpl implements HttpClient {

  private final Authorization authorization;

  private OkHttpClient client;

  private final Gson gson = new Gson();

  public HttpClientImpl(Authorization authorization) {
    this.authorization = authorization;
    setTimeOut();
  }

  private void setTimeOut() {
    client = new OkHttpClient.Builder()
      .connectTimeout(20, TimeUnit.SECONDS)
      .writeTimeout(20, TimeUnit.SECONDS)
      .readTimeout(20, TimeUnit.SECONDS)
      .build();
  }

  @Override
  public void post(String path, Headers headers, RequestBody body, ApiResponse apiResponse) {
    Request request = createRequest("POST", path, headers, body);
    call(request, apiResponse);
  }
  @Override
  public void get(String path, Headers headers, ApiResponse apiResponse) {
    Request request = createRequest("GET", path, headers, null);
    call(request, apiResponse);
  }
  @Override
  public void put(String path, Headers headers, RequestBody body, ApiResponse apiResponse) {
    Request request = createRequest("PUT", path, headers, body);
    call(request, apiResponse);
  }


  private void call(Request request, ApiResponse apiResponse) {
    client.newCall(request).enqueue(new Callback() {

      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {
        apiResponse.onError(Constants.ERR_NETWORK);
      }
      @Override
      public void onResponse(@NotNull Call call, @NotNull Response response) {
        handleResponse(response, apiResponse);
      }
    });
  }

  private void handleResponse(@NotNull Response response, @NotNull ApiResponse apiResponse) {
    if (response.isSuccessful()) {
      if (response.body() == null) {
        apiResponse.onSuccess("");
      } else {
        try {
          apiResponse.onSuccess(response.body().string());
        } catch (IOException e) {
          apiResponse.onError(Constants.ERR_UNKNOWN);
        }
      }
    } else {
      if (response.body() == null) {
        apiResponse.onError(Constants.ERR_UNKNOWN);
      } else {
        try {
          ErrorResponse errorResponse = gson.fromJson(
            response.body().string(),
            ErrorResponse.class
          );
          apiResponse.onError(errorResponse.message);
        } catch (Exception e) {
          apiResponse.onError(getErrorMessage(e));
        }
      }
    }
  }

  private String getErrorMessage(Exception e) {
    if (e instanceof SocketTimeoutException) {
      return Constants.ERR_TECHNICAL_ISSUE;
    } else {
      return Constants.ERR_UNKNOWN;
    }
  }

  private Request createRequest(
    String method,
    String path,
    Headers headers,
    RequestBody body) {
    return new Request.Builder()
      .url(getBaseUrl() + path)
      .headers(headers)
      .addHeader("Authorization", "Basic " + this.authorization.value())
      .method(method, body)
      .build();
  }

  private String getBaseUrl() {
    Environment env = LiberalizeBE.getInstance().getEnv();
    switch (env) {
      case PRODUCTION:
        return Constants.PROD_PAYMENT_API;
      case STAGING:
        return Constants.STAGING_PAYMENT_API;
      default:
        return Constants.DEV_PAYMENT_API;
    }
  }
}

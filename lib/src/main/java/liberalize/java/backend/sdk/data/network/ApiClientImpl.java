package liberalize.java.backend.sdk.data.network;

import com.google.gson.Gson;

import javax.annotation.Nullable;

import liberalize.java.backend.sdk.data.model.AuthorizePaymentRequest;
import liberalize.java.backend.sdk.data.model.CapturePaymentRequest;
import liberalize.java.backend.sdk.data.model.CreatePaymentRequest;
import liberalize.java.backend.sdk.data.model.PaymentDetailsResponse;
import liberalize.java.backend.sdk.data.model.PaymentFlowResponse;
import liberalize.java.backend.sdk.data.model.RefundPaymentRequest;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApiClientImpl implements ApiClient {
  private final HttpClient httpClient;

  private final Gson gson = new Gson();

  public ApiClientImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public void createPayment(
    CreatePaymentRequest createPaymentRequest,
    String libService,
    ApiResult<PaymentFlowResponse> apiResult
  ) {
    String body = gson.toJson(createPaymentRequest);
    postData(Constants.PAYMENTS, body, libService, apiResult);
  }

  @Override
  public void authorizePayment(
    AuthorizePaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  ) {
    String body = gson.toJson(request);
    String path = Constants.PAYMENTS + "/" + paymentId + Constants.AUTHORIZATIONS;
    postData(path, body, libService, apiResult);
  }

  @Override
  public void capturePayment(
    CapturePaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  ) {
    String body = gson.toJson(request);
    String path = Constants.PAYMENTS + "/" + paymentId + Constants.CAPTURES;
    postData(path, body, libService, apiResult);
  }
  @Override
  public void voidPayment(
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  ) {
    String path = Constants.PAYMENTS + "/" + paymentId + Constants.VOIDS;
    postData(path, "{}", libService, apiResult);
  }

  @Override
  public void refundPayment(
    RefundPaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  ) {
    String body = gson.toJson(request);
    String path = Constants.PAYMENTS + "/" + paymentId + Constants.REFUNDS;
    postData(path, body, libService, apiResult);
  }

  @Override
  public void getPayment(String libService, String paymentId, ApiResult<PaymentDetailsResponse> apiResult) {
    String path = Constants.PAYMENTS + "/" + paymentId;
    httpClient.get(path, createHeaders(libService), new ApiResponse() {
      @Override
      public void onSuccess(String body) {
        try {
          PaymentDetailsResponse paymentResponse = gson.fromJson(body, PaymentDetailsResponse.class);
          apiResult.onSuccess(paymentResponse);
        } catch (Exception e) {
          e.printStackTrace();
          apiResult.onError(Constants.ERR_TECHNICAL_ISSUE);
        }
      }
      @Override
      public void onError(String errorMessage) {
        apiResult.onError(errorMessage);
      }
    });
  }

  private Headers createHeaders(String libService) {
    return Headers.of(Constants.HEADER_LIB_SERVICE, libService);
  }

  private void postData(
    String path,
    @Nullable String body,
    String libService,
    ApiResult<PaymentFlowResponse> apiResult
  ) {
    RequestBody requestBody = null;
    MediaType json = MediaType.parse("application/json; charset=utf-8");
    if (body != null) {
      requestBody = RequestBody.create(json, body);
    }
    httpClient.post(path,
      createHeaders(libService),
      requestBody,
      new ApiResponse() {
        @Override
        public void onSuccess(String body) {
          try {
            PaymentFlowResponse paymentResponse = gson.fromJson(body, PaymentFlowResponse.class);
            apiResult.onSuccess(paymentResponse);
          } catch (Exception e) {
            e.printStackTrace();
            apiResult.onError(Constants.ERR_TECHNICAL_ISSUE);
          }
        }

        @Override
        public void onError(String errorMessage) {
          apiResult.onError(errorMessage);
        }
      });
  }
}

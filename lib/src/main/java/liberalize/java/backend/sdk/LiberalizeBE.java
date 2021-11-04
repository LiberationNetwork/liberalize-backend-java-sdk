package liberalize.java.backend.sdk;

import liberalize.java.backend.sdk.data.model.AuthorizePaymentRequest;
import liberalize.java.backend.sdk.data.model.CapturePaymentRequest;
import liberalize.java.backend.sdk.data.model.CreatePaymentRequest;
import liberalize.java.backend.sdk.data.model.PaymentDetailsResponse;
import liberalize.java.backend.sdk.data.model.PaymentFlowResponse;
import liberalize.java.backend.sdk.data.model.RefundPaymentRequest;
import liberalize.java.backend.sdk.data.network.ApiClient;
import liberalize.java.backend.sdk.data.network.ApiClientImpl;
import liberalize.java.backend.sdk.data.network.ApiResult;
import liberalize.java.backend.sdk.data.network.Authorization;
import liberalize.java.backend.sdk.data.network.Environment;
import liberalize.java.backend.sdk.data.network.HttpClientImpl;

public class LiberalizeBE {

  private static LiberalizeBE instance = null;


  private Environment environment;
  protected ApiClient apiClient;

  protected LiberalizeBE() {}

  /**
   * Set private key
   *
   * @param key private key
   */
  public void setPrivateKey(String key) {
    if (key == null) {
      throw new NullPointerException();
    }
    this.apiClient = new ApiClientImpl(
      new HttpClientImpl(new Authorization(key))
    );
  }

  /**
   * Set environment
   *
   * @param env environment enum
   * DEVELOPMENT
   * PRODUCTION
   * STAGING
   */
  public void setEnvironment(Environment env) {
    this.environment = env;
  }

  /**
   * Singleton
   *
   * @return LiberalizeBE
   */
  public static synchronized LiberalizeBE getInstance() {
    if (instance == null) {
      instance = new LiberalizeBE();
    }
    return instance;
  }

  /**
   * get Environment enum
   *
   * @return Environment
   */
  public Environment getEnv() {
    return environment;
  }

  /**
   * Create payment API
   *
   * @param createPaymentRequest payment request
   * @param libService payment service
   * @param result callback with PaymentFlowResponse
   */
  public void createPayment(
    CreatePaymentRequest createPaymentRequest,
    String libService,
    ApiResult<PaymentFlowResponse> result
  ) {
    apiClient.createPayment(createPaymentRequest, libService, result);
  }

  /**
   * Authorize payment API
   *
   * @param request authorize request
   * @param libService payment service
   * @param paymentId payment id
   * @param result callback with PaymentFlowResponse
   */
  public void authorizePayment(
    AuthorizePaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> result
  ) {
    apiClient.authorizePayment(request, libService, paymentId, result);
  }

  /**
   * Capture payment API
   *
   * @param request authorize request
   * @param libService payment service
   * @param paymentId payment id
   * @param result callback with PaymentFlowResponse
   */
  public void capturePayment(
    CapturePaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> result
  ) {
    apiClient.capturePayment(request, libService, paymentId, result);
  }

  /**
   * Void payment API
   *
   * @param libService payment service
   * @param paymentId payment id
   * @param result callback with PaymentFlowResponse
   */
  public void voidPayment(
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> result
  ) {
    apiClient.voidPayment(libService, paymentId, result);
  }

  /**
   * Refund payment API
   *
   * @param request Refund request
   * @param libService payment service
   * @param paymentId payment id
   * @param result callback with PaymentFlowResponse
   */
  public void refundPayment(
    RefundPaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> result
  ) {
    apiClient.refundPayment(request, libService, paymentId, result);
  }

  /**
   * Get payment details API
   *
   * @param libService payment service
   * @param paymentId payment id
   * @param result callback with PaymentDetailsResponse
   */
  public void getPayment(
    String libService,
    String paymentId,
    ApiResult<PaymentDetailsResponse> result) {
    apiClient.getPayment(libService, paymentId, result);
  }
}

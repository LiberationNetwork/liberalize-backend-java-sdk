package liberalize.java.backend.sdk.data.network;

import liberalize.java.backend.sdk.data.model.AuthorizePaymentRequest;
import liberalize.java.backend.sdk.data.model.CapturePaymentRequest;
import liberalize.java.backend.sdk.data.model.CreatePaymentRequest;
import liberalize.java.backend.sdk.data.model.PaymentDetailsResponse;
import liberalize.java.backend.sdk.data.model.PaymentFlowResponse;
import liberalize.java.backend.sdk.data.model.RefundPaymentRequest;

public interface ApiClient {

  void createPayment(
    CreatePaymentRequest createPaymentRequest,
    String libService,
    ApiResult<PaymentFlowResponse> apiResult
  );

  void authorizePayment(
    AuthorizePaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  );


  void capturePayment(
    CapturePaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  );

  void refundPayment(
    RefundPaymentRequest request,
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  );

  void voidPayment(
    String libService,
    String paymentId,
    ApiResult<PaymentFlowResponse> apiResult
  );

  void getPayment(
    String libService,
    String paymentId,
    ApiResult<PaymentDetailsResponse> apiResult
  );
}


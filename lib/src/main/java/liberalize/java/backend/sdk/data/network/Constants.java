package liberalize.java.backend.sdk.data.network;

public class Constants {
  // base url
  public static final String PROD_PAYMENT_API = "https://payment.api.liberalize.io";
  public static final String STAGING_PAYMENT_API = "https://payment.api.staging.liberalize.io";
  public static final String DEV_PAYMENT_API = "https://payment.api.dev.liberalize.io";

  // path
  public static final String PAYMENTS = "/payments";
  public static final String AUTHORIZATIONS = "/authorizations";
  public static final String CAPTURES = "/captures";
  public static final String REFUNDS = "/refunds";
  public static final String VOIDS = "/voids";

  // header
  public static final String HEADER_LIB_SERVICE = "x-lib-pos-type";

  //Error message
  public static final String ERR_UNKNOWN = "Unknown error";
  public static final String ERR_NETWORK = "No internet connection";
  public static final String ERR_TECHNICAL_ISSUE = "Oops! Technical issue";

}

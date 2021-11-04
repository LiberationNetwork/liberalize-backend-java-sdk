package liberalize.java.backend.sdk.data.network;

public interface ApiResult<T> {
  void onError(String errorMsg);
  void onSuccess(T response);
}

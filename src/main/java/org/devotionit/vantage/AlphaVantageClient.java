package org.devotionit.vantage;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.http.Http;
import org.devotionit.vantage.core.http.listener.ResponseListener;
import org.devotionit.vantage.core.parser.JsonPaser;
import org.devotionit.vantage.core.request.ApiRequest;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static java.util.Objects.requireNonNull;
import static org.devotionit.vantage.core.http.HttpConfig.VANTAGE_API_URL;

/**
 * Represents alpha vantage http client.
 *
 * @author Strahinja Mitrović
 */
@Slf4j
@ToString
@EqualsAndHashCode
public class AlphaVantageClient {
  private HttpClient http;
  private ObjectMapper mapper;
  private final String apiKey;

  public AlphaVantageClient(String apiKey) {
    this.apiKey = requireNonNull(apiKey, "Alpha Vantage api-key can't be null.");
    this.http = requireNonNull(Http.getHttpClient(), "Http client can't be null.");
    this.mapper = requireNonNull(JsonPaser.getInstance(), "Object mapper can't be null.");
  }

  /**
   * Method is used for synchronously executing alpha vantage request.
   *
   * @param apiRequest {@link ApiRequest <T>}
   * @return {@link Optional<String>}
   */
  public <T> T getSync(ApiRequest<T> apiRequest) {
    try {
      Class<T> clazz = (Class<T>) getGenericType(apiRequest.getClass());
      Request request = newRequest();
      setParams(request, apiRequest);
      ContentResponse response = request.send();
      return mapper.readValue(response.getContentAsString(), clazz);
    } catch (InterruptedException e) {
      log.error("Thread has been interrupted.", e);
      Thread.currentThread().interrupt();
    } catch (TimeoutException | ExecutionException | IOException e) {
      log.error("Request failed.", e);
      throw new AlphaVantageException("Request failed.");
    }
    return null;
  }

  /**
   * Method is used for asynchronously executing alpha vantage request.
   *
   * @param apiRequest {@link ApiRequest<T>}
   * @return {@link CompletableFuture<T>}
   */
  public <T> CompletableFuture<T> getAsync(ApiRequest<T> apiRequest) {
    CompletableFuture<T> future = new CompletableFuture<>();
    Class<T> clazz = (Class<T>) getGenericType(apiRequest.getClass());
    Request request = newRequest();
    setParams(request, apiRequest);
    request.send(new ResponseListener<T>(clazz, future));
    return future;
  }

  private Request newRequest() {
    Request request = http.newRequest(VANTAGE_API_URL);
    request.param("apikey", apiKey);
    return request;
  }

  private void setParams(Request httpRequest, ApiRequest apiRequest) {
    try {
      for (Field field : FieldUtils.getAllFields(apiRequest.getClass())) {
        field.setAccessible(true);
        httpRequest.param(field.getName(), String.valueOf(field.get(apiRequest)));
      }
    } catch (IllegalAccessException e) {
      log.error("Failed to set request params.", e);
      throw new IllegalArgumentException("Missing mandatory request params.");
    }
  }

  private Class<?> getGenericType(Class<?> clazz) {
    return (Class<?>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
  }
}

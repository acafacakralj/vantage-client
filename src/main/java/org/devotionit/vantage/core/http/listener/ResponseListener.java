package org.devotionit.vantage.core.http.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.devotionit.vantage.core.AlphaVantageException;
import org.devotionit.vantage.core.parser.JsonPaser;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Class is an extension of {@link BufferingResponseListener} class.
 *
 * @param <T>
 * @author Strahinja Mitrović
 */
@Slf4j
public class ResponseListener<T> extends BufferingResponseListener {
  private static ObjectMapper mapper = JsonPaser.getInstance();
  private Class<T> clazz;
  private CompletableFuture<T> future;

  public ResponseListener(Class<T> clazz, CompletableFuture<T> future) {
    this.clazz = clazz;
    this.future = future;
  }

  @Override
  public void onComplete(Result result) {
    try {
      int status = result.getResponse().getStatus();
      if (status < 200 && status > 300) {
        future.completeExceptionally(result.getResponseFailure());
        return;
      }
      String response = getContentAsString();
      if (response.contains("\"Error Message\"")) {
        future.completeExceptionally(new AlphaVantageException(response));
        return;
      }
      future.complete(mapper.readValue(response, clazz));
    } catch (IOException e) {
      log.error("Failed to parse json.", e);
    }
  }
}

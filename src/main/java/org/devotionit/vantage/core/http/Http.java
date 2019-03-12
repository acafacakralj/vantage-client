package org.devotionit.vantage.core.http;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import java.util.Objects;

import static org.devotionit.vantage.core.http.HttpConfig.*;


/**
 * Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization
 * mechanism. It is used for creating and configuring jetty {@link HttpClient}.
 *
 * @author Strahinja Mitrović
 */
@Slf4j
public class Http {
  private static HttpClient httpClient;

  private Http() {
  }

  /**
   * Method is used for creating and configuring only once {@link HttpClient} lazy-loading.
   *
   * @return {@link HttpClient}
   */
  public static synchronized HttpClient getHttpClient() {
    if (!Objects.isNull(httpClient)) {
      return httpClient;
    }
    try {
      SslContextFactory sslContextFactory = new SslContextFactory();
      httpClient = new HttpClient(sslContextFactory);
      httpClient.setFollowRedirects(FOLLOW_REDIRECTS);
      httpClient.setMaxConnectionsPerDestination(MAX_CONNECTIONS_PER_DEST);
      httpClient.setMaxRequestsQueuedPerDestination(MAX_REQUESTS_QUEUED_PER_DEST);
      httpClient.setRequestBufferSize(REQUEST_BUFFER_SIZE);
      httpClient.setResponseBufferSize(RESPONSE_BUFFER_SIZE);
      httpClient.setMaxRedirects(MAX_REDIRECTS);
      httpClient.setConnectTimeout(CONNECT_TIMEOUT);
      httpClient.setAddressResolutionTimeout(ADDRESS_RESOLUTION_TIMEOUT);
      httpClient.setConnectBlocking(CONNECT_BLOCKING);
      httpClient.setRemoveIdleDestinations(REMOVE_IDLE_DEST);
      httpClient.setStrictEventOrdering(STRICT_EVENT_ORDERING);
      httpClient.setTCPNoDelay(TCP_NO_DELAY);
      httpClient.start();
    } catch (Exception e) {
      log.error("Failed to create and configure http client.", e);
      System.exit(0);
    }
    return httpClient;
  }
}

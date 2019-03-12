package org.devotionit.vantage.core.http;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class provides common configuration properties for http.
 *
 * @author Strahinja Mitrović
 */
@Slf4j
public class HttpConfig {
  public static final boolean FOLLOW_REDIRECTS;
  public static final int MAX_CONNECTIONS_PER_DEST;
  public static final int CONNECT_TIMEOUT;
  public static final int MAX_REDIRECTS;
  public static final int MAX_REQUESTS_QUEUED_PER_DEST;
  public static final int REQUEST_BUFFER_SIZE;
  public static final int RESPONSE_BUFFER_SIZE;
  public static final int ADDRESS_RESOLUTION_TIMEOUT;
  public static final boolean CONNECT_BLOCKING;
  public static final boolean REMOVE_IDLE_DEST;
  public static final boolean STRICT_EVENT_ORDERING;
  public static final boolean TCP_NO_DELAY;
  public static final String VANTAGE_API_URL;
  public static final String VANTAGE_API_KEY;
  private static final Properties PROPS = new Properties();

  static {
    HttpConfig.loadConfig();

    FOLLOW_REDIRECTS = Boolean.valueOf(PROPS.getProperty("http.follow-redirects"));
    MAX_CONNECTIONS_PER_DEST = Integer.valueOf(PROPS.getProperty("http.max-connections"));
    CONNECT_TIMEOUT = Integer.valueOf(PROPS.getProperty("http.connect-timeout"));
    MAX_REDIRECTS = Integer.valueOf(PROPS.getProperty("http.max-redirects"));
    MAX_REQUESTS_QUEUED_PER_DEST = Integer.valueOf(PROPS.getProperty("http.max-requests-queued-per-dest"));
    REQUEST_BUFFER_SIZE = Integer.valueOf(PROPS.getProperty("http.request-buffer-size"));
    RESPONSE_BUFFER_SIZE = Integer.valueOf(PROPS.getProperty("http.response-buffer-size"));
    ADDRESS_RESOLUTION_TIMEOUT = Integer.valueOf(PROPS.getProperty("http.address-resolution-timeout"));
    CONNECT_BLOCKING = Boolean.valueOf(PROPS.getProperty("http.connect-blocking"));
    REMOVE_IDLE_DEST = Boolean.valueOf(PROPS.getProperty("http.remove-idle-dest"));
    STRICT_EVENT_ORDERING = Boolean.valueOf(PROPS.getProperty("http.strict-event-ordering"));
    TCP_NO_DELAY = Boolean.valueOf(PROPS.getProperty("http.tcp-no-delay"));
    VANTAGE_API_URL = PROPS.getProperty("http.alpha-vantage.url");
    VANTAGE_API_KEY = PROPS.getProperty("http.alpha-vantage.api-key");
  }

  private HttpConfig() {
  }

  private static void loadConfig() {
    try {
      InputStream in = Thread.currentThread()
        .getContextClassLoader()
        .getResourceAsStream("config.properties");
      PROPS.load(in);
    } catch (IOException e) {
      log.error("Failed to load configuration proeprties.", e);
      System.exit(0);
    }
  }
}

package org.devotionit.vantage.ut.core.http;

import org.devotionit.vantage.core.http.Http;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HttpTest {
  @Test
  public void Should_CreateHttpClient() {
    assertNotNull(Http.getHttpClient());
  }
}

package org.devotionit.vantage.ut;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.devotionit.vantage.AlphaVantageClient;
import org.devotionit.vantage.core.http.Http;
import org.devotionit.vantage.core.parser.JsonPaser;
import org.eclipse.jetty.client.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Http.class, JsonPaser.class})
@PowerMockIgnore("javax.management.*")
public class AlphaVantageClientTest {
  private String apiKey;
  private HttpClient httpClient;
  private ObjectMapper objectMapper;

  @Before
  public void setUpBeforeTest() {
    PowerMockito.mockStatic(Http.class);
    PowerMockito.mockStatic(JsonPaser.class);

    apiKey = "apiKey";
    httpClient = Mockito.mock(HttpClient.class);
    objectMapper = Mockito.mock(ObjectMapper.class);
  }

  @Test
  public void Should_CreateAlphaVantageClient_For_ValidData() {
    Mockito.when(Http.getHttpClient()).thenReturn(httpClient);
    Mockito.when(JsonPaser.getInstance()).thenReturn(objectMapper);

    AlphaVantageClient alphaVantageClient = new AlphaVantageClient(apiKey);
    assertNotNull(alphaVantageClient);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateAlphaVantageClient_When_ApiKeyIsNull() {
    Mockito.when(Http.getHttpClient()).thenReturn(httpClient);
    Mockito.when(JsonPaser.getInstance()).thenReturn(objectMapper);

    new AlphaVantageClient(null);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateAlphaVantageClient_When_HttpIsNull() {
    Mockito.when(Http.getHttpClient()).thenReturn(null);
    Mockito.when(JsonPaser.getInstance()).thenReturn(objectMapper);

    new AlphaVantageClient(apiKey);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateAlphaVantageClient_When_ObjectMapperIsNull() {
    Mockito.when(Http.getHttpClient()).thenReturn(httpClient);
    Mockito.when(JsonPaser.getInstance()).thenReturn(null);

    new AlphaVantageClient(apiKey);
  }
}

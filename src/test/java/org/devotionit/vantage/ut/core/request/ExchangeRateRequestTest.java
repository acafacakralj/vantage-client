package org.devotionit.vantage.ut.core.request;

import org.devotionit.vantage.core.request.ExchangeRateRequest;
import org.devotionit.vantage.core.request.param.FromCurrency;
import org.devotionit.vantage.core.request.param.ToCurrency;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ExchangeRateRequestTest {
  @Test
  public void Should_CreateRequest_When_DataIsValid() {
    ExchangeRateRequest request = new ExchangeRateRequest(FromCurrency.from("USD"), ToCurrency.from("EUR"));
    assertNotNull(request);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_FromCurrencyIsNull() {
    new ExchangeRateRequest(null, ToCurrency.from("EUR"));
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_ToCurrencyIsNull() {
    new ExchangeRateRequest(FromCurrency.from("USD"), null);
  }
}

package org.devotionit.vantage.ut.core.request;

import org.devotionit.vantage.core.request.DigitalCurrencyRequest;
import org.devotionit.vantage.core.request.param.Market;
import org.devotionit.vantage.core.request.param.Symbol;
import org.junit.Test;

import static org.devotionit.vantage.core.request.param.Function.CRYPTO_CURRENCY_DAILY;
import static org.junit.Assert.assertNotNull;

public class DigitalCurrencyRequestTest {
  @Test
  public void Should_CreateRequest_When_DataIsValid() {
    DigitalCurrencyRequest request = DigitalCurrencyRequest.builder()
      .function(CRYPTO_CURRENCY_DAILY)
      .market(Market.from("BYC"))
      .symbol(Symbol.from("BTC"))
      .build();
    assertNotNull(request);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_FunctionIsNull() {
    DigitalCurrencyRequest.builder()
      .function(null)
      .market(Market.from("BYC"))
      .symbol(Symbol.from("BTC"))
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_MarketIsNull() {
    DigitalCurrencyRequest.builder()
      .function(CRYPTO_CURRENCY_DAILY)
      .market(null)
      .symbol(Symbol.from("BTC"))
      .build();
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_SymbolIsNull() {
    DigitalCurrencyRequest.builder()
      .function(CRYPTO_CURRENCY_DAILY)
      .market(Market.from("BYC"))
      .symbol(null)
      .build();
  }
}

package org.devotionit.vantage.ut.core.request;

import org.devotionit.vantage.core.request.QuoteRequest;
import org.devotionit.vantage.core.request.param.Symbol;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class QuoteRequestTest {
  @Test
  public void Should_CreateRequest_When_DataIsValid() {
    QuoteRequest request = new QuoteRequest(Symbol.from("BYN"));
    assertNotNull(request);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateRequest_When_SymbolIsNull() {
    new QuoteRequest(null);
  }
}

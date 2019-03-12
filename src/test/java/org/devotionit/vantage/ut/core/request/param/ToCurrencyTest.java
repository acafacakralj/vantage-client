package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.ToCurrency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ToCurrencyTest {
  @Test
  public void Should_CreateToCurrency_When_DataIsValid() {
    ToCurrency toCurrency = ToCurrency.from("USD");
    assertNotNull(toCurrency);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateToCurrency_When_DataIsNull() {
    ToCurrency.from(null);
  }

  @Test
  public void Should_ReturnToCurrencyQueryParamName() {
    ToCurrency toCurrency = ToCurrency.from("USD");
    assertNotNull(toCurrency);
    assertEquals("to_currency", toCurrency.getName());
  }

  @Test
  public void Should_ReturnToCurrencyQueryParamValue() {
    String testData = "USD";
    ToCurrency toCurrency = ToCurrency.from(testData);
    assertNotNull(toCurrency);
    assertEquals(toCurrency.getValue(), testData);
  }
}

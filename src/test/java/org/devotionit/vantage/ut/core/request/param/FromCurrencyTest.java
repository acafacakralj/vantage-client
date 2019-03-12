package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.FromCurrency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FromCurrencyTest {
  @Test
  public void Should_CreateFromCurrency_When_DataIsValid() {
    FromCurrency fromCurrency = FromCurrency.from("USD");
    assertNotNull(fromCurrency);
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateFromCurrency_When_DataIsNull() {
    FromCurrency.from(null);
  }

  @Test
  public void Should_ReturnFromCurrencyQueryParamName() {
    FromCurrency fromCurrency = FromCurrency.from("USD");
    assertNotNull(fromCurrency);
    assertEquals("from_currency", fromCurrency.getName());
  }

  @Test
  public void Should_ReturnFromCurrencyQueryParamValue() {
    String testData = "BYC";
    FromCurrency currency = FromCurrency.from(testData);
    assertNotNull(currency);
    assertEquals(currency.getValue(), testData);
  }
}

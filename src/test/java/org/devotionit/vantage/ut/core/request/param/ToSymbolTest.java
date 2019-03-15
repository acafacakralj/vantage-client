package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.ToSymbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ToSymbolTest {
  @Test
  public void Should_CreateToSymbol_When_DataIsValid() {
    assertNotNull(ToSymbol.from("BYC"));
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateToSymbol_When_DataIsNull() {
    ToSymbol.from(null);
  }

  @Test
  public void Should_ReturnToSymbolQueryParamName() {
    ToSymbol toSymbol = ToSymbol.from("USD");
    assertNotNull(toSymbol);
    assertEquals("to_symbol", toSymbol.getName());
  }

  @Test
  public void Should_ReturnToCurrencyQueryParamValue() {
    String testData = "USD";
    ToSymbol toSymbol = ToSymbol.from(testData);
    assertNotNull(toSymbol);
    assertEquals(toSymbol.getValue(), testData);
  }
}

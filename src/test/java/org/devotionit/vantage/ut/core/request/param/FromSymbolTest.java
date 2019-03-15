package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.FromSymbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FromSymbolTest {
  @Test
  public void Should_CreateFromSymbol_When_DataIsValid() {
    assertNotNull(FromSymbol.from("BYC"));
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateFromSymbol_When_DataIsNull() {
    FromSymbol.from(null);
  }

  @Test
  public void Should_ReturnFromSymbolQueryParamName() {
    FromSymbol fromSymbol = FromSymbol.from("BYC");
    assertNotNull(fromSymbol);
    assertEquals("from_symbol", fromSymbol.getName());
  }

  @Test
  public void Should_ReturnFromSymbolQueryParamValue() {
    String testData = "BYC";
    FromSymbol symbol = FromSymbol.from(testData);
    assertNotNull(symbol);
    assertEquals(symbol.getValue(), testData);
  }
}

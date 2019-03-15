package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.Symbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SymbolTest {
  @Test
  public void Should_CreateSymbol_When_DataIsValid() {
    assertNotNull(Symbol.from("BYC"));
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateSymbol_When_DataIsNull() {
    Symbol.from(null);
  }

  @Test
  public void Should_ReturnSymbolQueryParamName() {
    Symbol symbol = Symbol.from("BA");
    assertNotNull(symbol);
    assertEquals("symbol", symbol.getName());
  }

  @Test
  public void Should_ReturnSymbolQueryParamValue() {
    String testData = "BYC";
    Symbol symbol = Symbol.from(testData);
    assertNotNull(symbol);
    assertEquals(symbol.getValue(), testData);
  }
}

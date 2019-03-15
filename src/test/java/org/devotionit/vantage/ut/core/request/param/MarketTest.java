package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.Market;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarketTest {
  @Test
  public void Should_CreateMarket_When_DataIsValid() {
    assertNotNull(Market.from("BYC"));
  }

  @Test(expected = NullPointerException.class)
  public void Should_FailToCreateMarket_When_DataIsNull() {
    Market.from(null);
  }

  @Test
  public void Should_ReturnMarketQueryParamName() {
    Market market = Market.from("BA");
    assertNotNull(market);
    assertEquals("market", market.getName());
  }

  @Test
  public void Should_ReturnMarketQueryParamValue() {
    String testData = "BYC";
    Market market = Market.from(testData);
    assertNotNull(market);
    assertEquals(market.getValue(), testData);
  }
}

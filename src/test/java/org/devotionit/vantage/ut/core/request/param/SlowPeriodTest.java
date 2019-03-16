package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.SlowPeriod;
import org.junit.Test;

public class SlowPeriodTest {
  @Test
  public void Should_CreateSlowPeriod_When_DataIsValid() {
    assertNotNull(SlowPeriod.from(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_FailToCreateSlowPeriod_When_DataLessThenZero() {
    SlowPeriod.from(-1);
  }

  @Test
  public void Should_ReturnSlowPeriodQueryParamName() {
    SlowPeriod slowPeriod = SlowPeriod.from(1);
    assertNotNull(slowPeriod);
    assertEquals("slowperiod", slowPeriod.getName());
  }

  @Test
  public void Should_ReturnSlowPeriodQueryParamValue() {
    int testData = 1;
    SlowPeriod slowPeriod = SlowPeriod.from(testData);
    assertNotNull(slowPeriod);
    assertEquals(testData, Integer.parseInt(slowPeriod.getValue()), 0);
  }
}

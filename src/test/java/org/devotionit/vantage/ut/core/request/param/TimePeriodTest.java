package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.TimePeriod;
import org.junit.Test;

public class TimePeriodTest {

  @Test
  public void Should_CreateTimePeriod_When_DataIsValid() {
    assertNotNull(TimePeriod.from(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_FailToCreateTimePeriod_When_DataLessThenZero() {
    TimePeriod.from(-1);
  }

  @Test
  public void Should_ReturnTimePeriodQueryParamName() {
    TimePeriod timePeriod = TimePeriod.from(1);
    assertNotNull(timePeriod);
    assertEquals("time_period", timePeriod.getName());
  }

  @Test
  public void Should_ReturnTimePeriodQueryParamValue() {
    int testData = 1;
    TimePeriod timePeriod = TimePeriod.from(testData);
    assertNotNull(timePeriod);
    assertEquals(testData, Integer.parseInt(timePeriod.getValue()), 0);
  }

}

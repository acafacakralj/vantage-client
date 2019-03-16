package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.FastDPeriod;
import org.junit.Test;

public class FastDPeriodTest {
  @Test
  public void Should_CreateFastDPeriod_When_DataIsValid() {
    assertNotNull(FastDPeriod.from(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_CreateFastDPeriod_When_DataIsInvalid() {
    FastDPeriod.from(-1);
  }

  @Test
  public void Should_ReturnFastDPeriodQueryParamName() {
    FastDPeriod dPeriod = FastDPeriod.from(1);
    assertNotNull(dPeriod);
    assertEquals("fastdperiod", dPeriod.getName());
  }

  @Test
  public void Should_ReturnFastDPeriodQueryParamValue() {
    FastDPeriod dPeriod = FastDPeriod.from(1);
    assertNotNull(dPeriod);
    assertEquals(1, Integer.parseInt(dPeriod.getValue()), 0);
  }
}

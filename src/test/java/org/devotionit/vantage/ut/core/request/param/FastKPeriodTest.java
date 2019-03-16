package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.FastKPeriod;
import org.junit.Test;

public class FastKPeriodTest {
  @Test
  public void Should_CreateFastKPeriod_When_DataIsValid() {
    assertNotNull(FastKPeriod.from(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_CreateFastKPeriod_When_DataIsInvalid() {
    FastKPeriod.from(-1);
  }

  @Test
  public void Should_ReturnFastKPeriodQuaryParamName() {
    FastKPeriod fastKPeriod = FastKPeriod.from(1);
    assertNotNull(fastKPeriod);
    assertEquals("fastkperiod", fastKPeriod.getName());
  }

  @Test
  public void Should_ReturnFastKPeriodQuaryParamValue() {
    int test = 1;
    FastKPeriod fastKPeriod = FastKPeriod.from(test);
    assertNotNull(fastKPeriod);
    assertEquals(test, Integer.parseInt(fastKPeriod.getValue()), 0);
  }
}

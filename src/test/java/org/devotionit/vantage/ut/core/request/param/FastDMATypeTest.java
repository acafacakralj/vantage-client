package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.FastDMAType;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FastDMATypeTest {
  @Test
  public void Should_CreateFastDMAType_When_DataIsValid() {
    Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(integer -> {
      assertNotNull(FastDMAType.from(integer));
    });
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_FailToCreateFastDMAType_When_DataIsLessThen0() {
    FastDMAType.from(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_FailToCreateFastDMAType_When_DataIsGreaterThen8() {
    FastDMAType.from(9);
  }

  @Test
  public void Should_ReturnFastDMATypeQueryParamName() {
    FastDMAType fastDMAType = FastDMAType.from(1);
    assertNotNull(fastDMAType);
    assertEquals("fastdmatype", fastDMAType.getName());
  }

  @Test
  public void Should_ReturnFastDMATypeQueryParamValue() {
    int testData = 1;
    FastDMAType fastDMAType = FastDMAType.from(testData);
    assertNotNull(fastDMAType);
    assertEquals(testData, Integer.parseInt(fastDMAType.getValue()));
  }
}

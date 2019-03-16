package org.devotionit.vantage.ut.core.request.param;

import org.devotionit.vantage.core.request.param.Acceleration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccelerationTest {
  @Test
  public void Should_CreateAcceleration_When_DataIsValid() {
    assertNotNull(Acceleration.from(1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void Should_FailToCreateAcceleration_When_DataLessThenZero() {
    Acceleration.from(-1);
  }

  @Test
  public void Should_ReturnAccelerationQueryParamName() {
    Acceleration acceleration = Acceleration.from(1);
    assertNotNull(acceleration);
    assertEquals("acceleration", acceleration.getName());
  }

  @Test
  public void Should_ReturnAccelerationQueryParamValue() {
    float testData = 1;
    Acceleration acceleration = Acceleration.from(testData);
    assertNotNull(acceleration);
    assertEquals(testData, Float.parseFloat(acceleration.getValue()), 0);
  }
}

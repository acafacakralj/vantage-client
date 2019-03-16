package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.MaxAcceleration;
import org.junit.Test;

public class MaxAccelerationTest {

	@Test
	public void Should_CreateMaxAcceleration_When_DataIsValid() {
		assertNotNull(MaxAcceleration.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateMaxAcceleration_When_DataLessThenZero() {
		MaxAcceleration.from(-1);
	}

	@Test
	public void Should_ReturnMaxAccelerationQueryParamName() {
		MaxAcceleration maxAcceleration = MaxAcceleration.from(1);
		assertNotNull(maxAcceleration);
		assertEquals("maximum", maxAcceleration.getName());
	}

	@Test
	public void Should_ReturnMaxAccelerationQueryParamValue() {
		float testData = 1;
		MaxAcceleration maxAcceleration = MaxAcceleration.from(testData);
		assertNotNull(maxAcceleration);
		assertEquals(testData, Float.parseFloat(maxAcceleration.getValue()), 0);
	}

}

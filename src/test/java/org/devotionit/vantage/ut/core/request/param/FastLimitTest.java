package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.FastLimit;
import org.junit.Test;

public class FastLimitTest {
	@Test
	public void Should_CreateFastLimit_When_DataIsValid() {
		assertNotNull(FastLimit.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_CreateAcceleration_When_DataIsInvalid() {
		FastLimit.from(-1);
	}

	@Test
	public void Should_ReturnFastLimitQueryParamName() {
		FastLimit fastLimit = FastLimit.from(1);
		assertNotNull(fastLimit);
		assertEquals("fastlimit", fastLimit.getName());
	}

	@Test
	public void Should_ReturnFastLimitQueryParamValue() {
		FastLimit fastLimit = FastLimit.from(1);
		assertNotNull(fastLimit);
		assertEquals(1, Float.parseFloat(fastLimit.getValue()), 0);
	}
}

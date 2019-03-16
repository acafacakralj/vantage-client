package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.SlowLimit;
import org.junit.Test;

public class SlowLimitTest {
	@Test
	public void Should_CreateSlowLimit_When_DataIsValid() {
		assertNotNull(SlowLimit.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowLimit_When_DataLessThenZero() {
		SlowLimit.from(-1);
	}

	@Test
	public void Should_ReturnSlowLimitQueryParamName() {
		SlowLimit slowLimit = SlowLimit.from(1);
		assertNotNull(slowLimit);
		assertEquals("slowlimit", slowLimit.getName());
	}

	@Test
	public void Should_ReturnSlowLimitQueryParamValue() {
		int testData = 1;
		SlowLimit slowLimit = SlowLimit.from(testData);
		assertNotNull(slowLimit);
		assertEquals(testData, Float.parseFloat(slowLimit.getValue()), 0);
	}
}

package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.SlowDPeriod;
import org.junit.Test;

public class SlowDPeriodTest {

	@Test
	public void Should_CreateSlowDPeriod_When_DataIsValid() {
		assertNotNull(SlowDPeriod.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowDPeriod_When_DataLessThenZero() {
		SlowDPeriod.from(-1);
	}

	@Test
	public void Should_ReturnAccelerationQueryParamName() {
		SlowDPeriod dPeriod = SlowDPeriod.from(1);
		assertNotNull(dPeriod);
		assertEquals("slowdperiod", dPeriod.getName());
	}

	@Test
	public void Should_ReturnAccelerationQueryParamValue() {
		int testData = 1;
		SlowDPeriod dPeriod = SlowDPeriod.from(testData);
		assertNotNull(dPeriod);
		assertEquals(testData, Integer.parseInt(dPeriod.getValue()), 0);
	}
}

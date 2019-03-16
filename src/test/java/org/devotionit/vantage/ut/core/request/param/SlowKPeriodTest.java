package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.SlowKPeriod;
import org.junit.Test;

public class SlowKPeriodTest {

	@Test
	public void Should_CreateSlowKPeriod_When_DataIsValid() {
		assertNotNull(SlowKPeriod.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowKPeriod_When_DataLessThenZero() {
		SlowKPeriod.from(-1);
	}

	@Test
	public void Should_ReturnSlowKPeriodQueryParamName() {
		SlowKPeriod kPeriod = SlowKPeriod.from(1);
		assertNotNull(kPeriod);
		assertEquals("slowkperiod", kPeriod.getName());
	}

	@Test
	public void Should_ReturnSlowKPeriodQueryParamValue() {
		int testData = 1;
		SlowKPeriod kPeriod = SlowKPeriod.from(testData);
		assertNotNull(kPeriod);
		assertEquals(testData, Integer.parseInt(kPeriod.getValue()), 0);
	}

}

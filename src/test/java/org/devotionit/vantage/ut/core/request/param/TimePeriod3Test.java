package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.TimePeriod3;
import org.junit.Test;

public class TimePeriod3Test {
	@Test
	public void Should_CreateTimePeriod3_When_DataIsValid() {
		assertNotNull(TimePeriod3.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateTimePeriod3_When_DataLessThenZero() {
		TimePeriod3.from(-1);
	}

	@Test
	public void Should_ReturnTimePeriod3QueryParamName() {
		TimePeriod3 timePeriod = TimePeriod3.from(1);
		assertNotNull(timePeriod);
		assertEquals("timeperiod3", timePeriod.getName());
	}

	@Test
	public void Should_ReturnTimePeriod3QueryParamValue() {
		int testData = 1;
		TimePeriod3 timePeriod = TimePeriod3.from(testData);
		assertNotNull(timePeriod);
		assertEquals(testData, Integer.parseInt(timePeriod.getValue()), 0);
	}
}

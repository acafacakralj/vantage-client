package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.TimePeriod1;
import org.junit.Test;

public class TimePeriod1Test {

	@Test
	public void Should_CreateTimePeriod1_When_DataIsValid() {
		assertNotNull(TimePeriod1.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateTimePeriod1_When_DataLessThenZero() {
		TimePeriod1.from(-1);
	}

	@Test
	public void Should_ReturnTimePeriod1QueryParamName() {
		TimePeriod1 timePeriod = TimePeriod1.from(1);
		assertNotNull(timePeriod);
		assertEquals("timeperiod1", timePeriod.getName());
	}

	@Test
	public void Should_ReturnTimePeriod1QueryParamValue() {
		int testData = 1;
		TimePeriod1 timePeriod = TimePeriod1.from(testData);
		assertNotNull(timePeriod);
		assertEquals(testData, Integer.parseInt(timePeriod.getValue()), 0);
	}

}

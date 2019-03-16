package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.TimePeriod2;
import org.junit.Test;

public class TimePeriod2Test {

	@Test
	public void Should_CreateTimePeriod2_When_DataIsValid() {
		assertNotNull(TimePeriod2.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateTimePeriod2_When_DataLessThenZero() {
		TimePeriod2.from(-1);
	}

	@Test
	public void Should_ReturnTimePeriod2QueryParamName() {
		TimePeriod2 timePeriod = TimePeriod2.from(1);
		assertNotNull(timePeriod);
		assertEquals("timeperiod2", timePeriod.getName());
	}

	@Test
	public void Should_ReturnTimePeriod2QueryParamValue() {
		int testData = 1;
		TimePeriod2 timePeriod = TimePeriod2.from(testData);
		assertNotNull(timePeriod);
		assertEquals(testData, Float.parseFloat(timePeriod.getValue()), 0);
	}

}

package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.SignalPeriod;
import org.junit.Test;

public class SignalPeriodTest {
	@Test
	public void Should_CreateSignalPeriod_When_DataIsValid() {
		assertNotNull(SignalPeriod.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSignalPeriod_When_DataLessThenZero() {
		SignalPeriod.from(-1);
	}

	@Test
	public void Should_ReturnSignalPeriodQueryParamName() {
		SignalPeriod period = SignalPeriod.from(1);
		assertNotNull(period);
		assertEquals("signalperiod", period.getName());
	}

	@Test
	public void Should_ReturnASignalPeriodQueryParamValue() {
		float testData = 1;
		SignalPeriod period = SignalPeriod.from(1);
		assertNotNull(period);
		assertEquals(testData, Integer.parseInt(period.getValue()), 0);
	}
}

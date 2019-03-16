package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.FastPeriod;
import org.junit.Test;

public class FastPeriodTest {

	@Test
	public void Should_CreateFastPeriod_When_DataIsValid() {
		assertNotNull(FastPeriod.from(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_CreateFastPeriod_When_DataIsInvalid() {
		FastPeriod.from(-1);

	}

	@Test
	public void Should_ReturnFastPeriodQueryParamName() {
		FastPeriod fastPeriod = FastPeriod.from(1);
		assertNotNull(fastPeriod);
		assertEquals("fastperiod", fastPeriod.getName());
	}

	@Test
	public void Should_ReturnFastPeriodQueryParamValue() {
		FastPeriod fastPeriod = FastPeriod.from(1);
		assertNotNull(fastPeriod);
		assertEquals(1, Integer.parseInt(fastPeriod.getValue()), 0);
	}

}

package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.devotionit.vantage.core.request.param.SlowDMAType;
import org.junit.Test;

public class SlowDMATypeTest {
	@Test
	public void Should_CreateSlowDMAType_When_DataIsValid() {
		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(integer -> {
			assertNotNull(SlowDMAType.from(integer));
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowDMAType_When_DataIsLessThen0() {
		SlowDMAType.from(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowDMAType_When_DataIsGreaterThen8() {
		SlowDMAType.from(9);
	}

	@Test
	public void Should_ReturnSlowDMATypeQueryParamName() {
		SlowDMAType slowDMAType = SlowDMAType.from(1);
		assertNotNull(slowDMAType);
		assertEquals("slowdmatype", slowDMAType.getName());
	}

	@Test
	public void Should_ReturnSlowDMATypeQueryParamValue() {
		int testData = 1;
		SlowDMAType slowDMAType = SlowDMAType.from(testData);
		assertNotNull(slowDMAType);
		assertEquals(testData, Integer.parseInt(slowDMAType.getValue()));
	}
}

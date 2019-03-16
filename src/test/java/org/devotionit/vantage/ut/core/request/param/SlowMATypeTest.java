package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.devotionit.vantage.core.request.param.SlowMAType;
import org.junit.Test;

public class SlowMATypeTest {

	@Test
	public void Should_CreateSlowMAType_When_DataIsValid() {
		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(integer -> {
			assertNotNull(SlowMAType.from(integer));
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowMAType_When_DataIsLessThen0() {
		SlowMAType.from(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSlowMAType_When_DataIsGreaterThen8() {
		SlowMAType.from(9);
	}

	@Test
	public void Should_ReturnSlowMATypeQueryParamName() {
		SlowMAType slowMAType = SlowMAType.from(1);
		assertNotNull(slowMAType);
		assertEquals("slowmatype", slowMAType.getName());
	}

	@Test
	public void Should_ReturnFastDMATypeQueryParamValue() {
		int testData = 1;
		SlowMAType slowMAType = SlowMAType.from(testData);
		assertNotNull(slowMAType);
		assertEquals(testData, Integer.parseInt(slowMAType.getValue()));
	}

}

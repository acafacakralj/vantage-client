package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.devotionit.vantage.core.request.param.MAType;
import org.junit.Test;

public class MATypeTest {

	@Test
	public void Should_CreateMAType_When_DataIsValid() {
		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(integer -> {
			assertNotNull(MAType.from(integer));
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateMAType_When_DataIsLessThen0() {
		MAType.from(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateMAType_When_DataIsGreaterThen8() {
		MAType.from(9);
	}

	@Test
	public void Should_ReturnFastDMATypeQueryParamName() {
		MAType maType = MAType.from(1);
		assertNotNull(maType);
		assertEquals("matype", maType.getName());
	}

	@Test
	public void Should_ReturnMATypeQueryParamValue() {
		int testData = 1;
		MAType maType = MAType.from(testData);
		assertNotNull(maType);
		assertEquals(testData, Integer.parseInt(maType.getValue()));
	}
}

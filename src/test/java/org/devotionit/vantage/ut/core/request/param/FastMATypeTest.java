package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.devotionit.vantage.core.request.param.FastMAType;
import org.junit.Test;

public class FastMATypeTest {

	@Test
	public void Should_CreateFastMAType_When_DataIsValid() {
		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(integer -> {
			assertNotNull(FastMAType.from(integer));
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateFastMAType_When_DataIsLessThen0() {
		FastMAType.from(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateFastMAType_When_DataIsGreaterThen8() {
		FastMAType.from(9);
	}

	@Test
	public void Should_ReturnFastMATypeQueryParamName() {
		FastMAType fastMAType = FastMAType.from(1);
		assertNotNull(fastMAType);
		assertEquals("fastmatype", fastMAType.getName());
	}

	@Test
	public void Should_ReturnFastMATypeQueryParamValue() {
		int testData = 1;
		FastMAType fastMAType = FastMAType.from(testData);
		assertNotNull(fastMAType);
		assertEquals(testData, Integer.parseInt(fastMAType.getValue()));
	}

}

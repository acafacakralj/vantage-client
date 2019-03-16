package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.devotionit.vantage.core.request.param.SignalMAType;
import org.junit.Test;

public class SignalMATypeTest {
	@Test
	public void Should_CreateSignalMAType_When_DataIsValid() {
		Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8).forEach(integer -> {
			assertNotNull(SignalMAType.from(integer));
		});
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSignalMAType_When_DataIsLessThen0() {
		SignalMAType.from(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateSignalMAType_When_DataIsGreaterThen8() {
		SignalMAType.from(9);
	}

	@Test
	public void Should_ReturnSignalMATypeQueryParamName() {
		SignalMAType signalMAType = SignalMAType.from(1);
		assertNotNull(signalMAType);
		assertEquals("signalmatype", signalMAType.getName());
	}

	@Test
	public void Should_ReturnSignalMATypeQueryParamValue() {
		int testData = 1;
		SignalMAType signalMAType = SignalMAType.from(1);
		assertNotNull(signalMAType);
		assertEquals(testData, Integer.parseInt(signalMAType.getValue()));
	}
}

package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.NBDEVUp;
import org.junit.Test;

public class NBDEVUpTest {
	@Test
	public void Should_CreateNBDEVUp_When_DataIsValid() {
		assertNotNull(NBDEVUp.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateNBDEVUp_When_DataLessThenZero() {
		NBDEVUp.from(-1);
	}

	@Test
	public void Should_ReturnNBDEVUpQueryParamName() {
		NBDEVUp up = NBDEVUp.from(1);
		assertNotNull(up);
		assertEquals("nbdevup", up.getName());
	}

	@Test
	public void Should_ReturnNBDEVUpQueryParamValue() {
		int testData = 1;
		NBDEVUp up = NBDEVUp.from(testData);
		assertNotNull(up);
		assertEquals(testData, Integer.parseInt(up.getValue()));
	}
}

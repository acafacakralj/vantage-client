package org.devotionit.vantage.ut.core.request.param;

import static org.junit.Assert.*;

import org.devotionit.vantage.core.request.param.NBDEVDn;
import org.junit.Test;

public class NBDEVDnTest {

	@Test
	public void Should_CreateNBDEVDn_When_DataIsValid() {
		assertNotNull(NBDEVDn.from(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Should_FailToCreateNBDEVDn_When_DataLessThenZero() {
		NBDEVDn.from(-1);
	}

	@Test
	public void Should_ReturnNBDEVDnQueryParamName() {
		NBDEVDn dn = NBDEVDn.from(1);
		assertNotNull(dn);
		assertEquals("nbdevdn", dn.getName());
	}

	@Test
	public void Should_ReturnNBDEVDnQueryParamValue() {
		int testData = 1;
		NBDEVDn dn = NBDEVDn.from(testData);
		assertNotNull(dn);
		assertEquals(testData, Integer.parseInt(dn.getValue()), 0);
	}

}

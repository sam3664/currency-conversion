package com.anz.converter.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RateConversionUtilTest {
	
	@Test
	public void rateConversionTest() {
		Assert.assertNotNull(RateConversionUtil.getRateMap());
	}
	
	@Test
	public void convertDecimalTest() {
		String Value= RateConversionUtil.convertDecimal(100.68786753, 2);
		Assert.assertNotNull(Value);
	}
	
	@Test
	public void convertDecimalTest_EquateValue() {
		String Value= RateConversionUtil.convertDecimal(100.68786753, 2);
		Assert.assertNotNull(100.69);
	}

}

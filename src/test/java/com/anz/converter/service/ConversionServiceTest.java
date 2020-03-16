package com.anz.converter.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConversionServiceTest {

	private ConversionService conversionService;
	
	@Before
	public void setup() {
		conversionService=new ConversionServiceImpl();
	}
	
	@Test
	public void getCurrencyConversionValueTest_valueInMap() {
		String from="AUD",to="USD";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue);
	}
	
	
	@Test
	public void getCurrencyConversionValueTest_inverted() {
		String from="USD",to="AUD";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue);
	}
	
	
	@Test
	public void getCurrencyConversionValueTest_WrongCurrency() {
		String from="USD",to="INR";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNull(convertedValue);
	}
	
	@Test
	public void getCurrencyConversionValueTest_Associated_Currency() {
		String from="AUD",to="CNY";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue); 
	}
	
	@Test
	public void getCurrencyConversionValueTest_Associated_Currency_result() {
		String from="AUD",to="CNY";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue); //516.62
		assertEquals("516.62", convertedValue);
	}
	
	@Test
	public void getCurrencyConversionValueTest_Associated_Currency_Inversion() {
		String from="AUD",to="CAD";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue); 
	}
	
	@Test
	public void getCurrencyConversionValueTest_Associated_Currency_Inversion_result() {
		String from="AUD",to="CAD";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue); 
		assertEquals("96.10", convertedValue);
	}
	
	@Test
	public void getCurrencyConversionValueTest_Associated_Currency_JPY_Decimal_check() {
		String from="AUD",to="JPY";
		Double value=100.00;
		String convertedValue=conversionService.getCurrencyConversionValue(from, to, value);
		assertNotNull(convertedValue); 
		assertEquals("10041", convertedValue);
	}

}

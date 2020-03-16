package com.anz.converter.constants;

import java.util.HashMap;
import java.util.Map;

/*
 * Maps the Currency with decimal values
 */
public enum CurrencyDecimalEnum {

	AUD(2), CAD(2), CNY(2), CZK(2), DKK(2), EUR(2), GBP(2), JPY(0), NOK(2), NZD(2), USD(2);
	
	 private static final Map<String, Integer> decimalMap = new HashMap<String, Integer>();

	private int decimalValue;

	CurrencyDecimalEnum(int decimalVal) {
		this.decimalValue = decimalVal;
	}
	
	 static {
	        for (CurrencyDecimalEnum decimalMapperEnum : CurrencyDecimalEnum.values()) {
	        	decimalMap.put(decimalMapperEnum.name(), decimalMapperEnum.getDecimalValue());
	        }
	    }

	public int getDecimalValue() {
		return decimalValue;
	}
	public static Map<String, Integer> getDecimalMap() {
		return decimalMap;
	}
}

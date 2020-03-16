package com.anz.converter.domain;

import java.util.Map;

import com.anz.converter.constants.CurrencyDecimalEnum;
import com.anz.converter.util.RateConversionUtil;

/*
 *  Mapping builder to fetch the conversion rate mapping and decimal mapping of currencies
 */
public class CurrencyMappingBuilder {

	private static Map<String, Double> RateMapperMap;
	private static Map<String, Integer> decimalMapperMap;

	static {
		RateMapperMap = RateConversionUtil.getRateMap();
		decimalMapperMap = CurrencyDecimalEnum.getDecimalMap();
	}

	public static Map<String, Double> getRateMapperMap() {
		return RateMapperMap;
	}

	public static Map<String, Integer> getDecimalMapperMap() {
		return decimalMapperMap;
	}
}

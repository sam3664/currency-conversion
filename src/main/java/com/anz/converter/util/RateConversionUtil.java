package com.anz.converter.util;

import java.util.HashMap;
import java.util.Map;

import com.anz.converter.constants.RateMapperEnum;

/*
 * Class has utility methods 
 * convertDecimal() : Convert double to string with given decimal value along with appropriate roundoff
 * getInversion() : will create the map with inverted currencies 
 */
public class RateConversionUtil {

	public static Map<String, Double> getRateMap() {
		Map<String, Double> RateMapperMap = RateMapperEnum.getRateMapperMap();
		return getInversion(RateMapperMap);
	}

	public static String convertDecimal(Double convertedValue, Integer decimalPlace) {
		if (null != decimalPlace) {
			return String.format("%." + decimalPlace + "f", convertedValue);
		} else {
			//default is .2f i.e 100.4687684 = 100.47
			return String.format("%.2f", convertedValue);
		}

	}

	// Add inversion in map, say from AUDUSD convert USDAUD
	private static Map<String, Double> getInversion(Map<String, Double> RateMapperMap) {
		Map<String, Double> invertedRateMapperMap = new HashMap<String, Double>();
		RateMapperMap.forEach((currency, mappingValue) -> {
			// System.out.println("Item : " + k + " Count : " + v);
			String invertCurrency = currency.substring(3, 6) + currency.substring(0, 3);
			invertedRateMapperMap.put(invertCurrency, 1 / mappingValue);
		});
		RateMapperMap.putAll(invertedRateMapperMap);

		return RateMapperMap;
	}

}

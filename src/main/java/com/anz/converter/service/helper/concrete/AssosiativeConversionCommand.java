package com.anz.converter.service.helper.concrete;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import com.anz.converter.domain.CurrencyMappingBuilder;
import com.anz.converter.service.helper.ConversionChain;
import com.anz.converter.service.helper.ConversionCommand;
/*
 * AssosiativeConversionCommand when direct conversion not available 
 * It finds the association between from and to currencies and returns the multiplication factor
 */

public class AssosiativeConversionCommand implements ConversionChain {

	private ConversionChain chain;
	@Override
	public Double executeConversion(String from, String to) {
		Map<String, Double> fromMap = new HashMap<String, Double>();
		Map<String, Double> toMap = new HashMap<String, Double>();

		// create two maps, first matching with start from currency and second matching
		// end currency
		try {
			CurrencyMappingBuilder.getRateMapperMap().forEach((currency, mappingValue) -> {

				if (currency.startsWith(from)) {
					fromMap.put(currency, mappingValue);
				}
				if (currency.endsWith(to)) {
					toMap.put(currency, mappingValue);
				}
			});

			// If the currency match directly not available
			// match the end currency substring of from currency with start substring to
			// For eg: AUDUSD and USDCNY, here end substr of AUDUSD= USD equates with start
			// substr of USDCNY
			// Multiple both the values and result is the associative conversion factor
			AtomicReference<Double> conversionRate = new AtomicReference<Double>();
			fromMap.forEach((fromCurrency, fromMappingValue) -> {

				toMap.forEach((tocurrency, tomappingValue) -> {

					if (fromCurrency.substring(3, 6).equalsIgnoreCase(tocurrency.substring(0, 3))) {
						conversionRate.set(fromMappingValue * tomappingValue);
					}
				});
			});

			if (null != conversionRate && null != conversionRate.get()) {
				return conversionRate.get();
			}
			return null;
		} catch (Exception e) {
			System.out.println("Exception occured " + e);
		}
		return null;
	}

	public static AssosiativeConversionCommand getAssosiativeConversionCommand() {
		return new AssosiativeConversionCommand();
	}

	@Override
	public void setNext() {
		this.chain=null;
	}

}

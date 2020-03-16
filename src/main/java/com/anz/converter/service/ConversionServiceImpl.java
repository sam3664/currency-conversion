package com.anz.converter.service;

import org.springframework.stereotype.Service;

import com.anz.converter.domain.CurrencyMappingBuilder;
import com.anz.converter.service.helper.concrete.AssosiativeConversionCommand;
import com.anz.converter.service.helper.concrete.DirectConversionCommand;
import com.anz.converter.service.helper.concrete.EqualCurrencyCommand;
import com.anz.converter.util.RateConversionUtil;

/*
 * Service class with business logic for Currency conversion
 */
@Service
public class ConversionServiceImpl implements ConversionService {

	public String getCurrencyConversionValue(String from, String to, Double value) {
		Double conversionRate = conversionFacade(from, to);
		if (null != conversionRate) {
			Double convertedValue = value * conversionRate;
			return RateConversionUtil.convertDecimal(convertedValue,
					CurrencyMappingBuilder.getDecimalMapperMap().get(to));
		}
		return null;
	}

	private Double conversionFacade(String from, String to) {
		// When both currencies are same
		if (from.equalsIgnoreCase(to)) {
			return EqualCurrencyCommand.getEqualCurrencyCommand().executeConversion(from, to);
		}
		// If the currency match directly available
		else if (CurrencyMappingBuilder.getRateMapperMap().containsKey(from + to)) {
			return DirectConversionCommand.getDirectConversionCommand().executeConversion(from, to);
		}
		// If direct conversion not available, do it through assocication
		else {
			return AssosiativeConversionCommand.getAssosiativeConversionCommand().executeConversion(from, to);
		}

	}
}

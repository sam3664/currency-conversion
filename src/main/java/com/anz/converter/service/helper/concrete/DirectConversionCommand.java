package com.anz.converter.service.helper.concrete;

import com.anz.converter.domain.CurrencyMappingBuilder;
import com.anz.converter.service.helper.ConversionCommand;

/*
 * When the conversion factor available in direct and inverted maps
 */
public class DirectConversionCommand implements ConversionCommand {

	@Override
	public Double executeConversion(String from, String to) {
		return CurrencyMappingBuilder.getRateMapperMap().get(from + to);
	}

	public static DirectConversionCommand getDirectConversionCommand() {
		return new DirectConversionCommand();
	}

}

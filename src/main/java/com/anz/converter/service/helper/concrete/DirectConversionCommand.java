package com.anz.converter.service.helper.concrete;

import com.anz.converter.domain.CurrencyMappingBuilder;
import com.anz.converter.service.helper.ConversionChain;

/*
 * When the conversion factor available in direct and inverted maps
 */
public class DirectConversionCommand implements ConversionChain {

	private ConversionChain chain;

	@Override
	public Double executeConversion(String from, String to) {
		if (CurrencyMappingBuilder.getRateMapperMap().containsKey(from + to)) {
			return CurrencyMappingBuilder.getRateMapperMap().get(from + to);
		} else {
			setNext();
			this.chain.executeConversion(from, to);
			return this.chain.executeConversion(from, to);
		}

	}

	public static DirectConversionCommand getDirectConversionCommand() {
		return new DirectConversionCommand();
	}

	@Override
	public void setNext() {
		this.chain = AssosiativeConversionCommand.getAssosiativeConversionCommand();

	}

}

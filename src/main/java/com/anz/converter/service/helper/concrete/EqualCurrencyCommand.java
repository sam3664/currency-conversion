package com.anz.converter.service.helper.concrete;

import com.anz.converter.service.helper.ConversionChain;

/*
 * When To and fromcurrency is same
 */
public class EqualCurrencyCommand implements ConversionChain {

	private ConversionChain chain;

	public Double executeConversion(String from, String to) {
		if (from.equalsIgnoreCase(to)) {
			return 1.0;
		} else {
			setNext();
			return this.chain.executeConversion(from, to);
		}
	}

	public static EqualCurrencyCommand getEqualCurrencyCommand() {
		return new EqualCurrencyCommand();
	}

	@Override
	public void setNext() {
		this.chain = DirectConversionCommand.getDirectConversionCommand();

	}

}

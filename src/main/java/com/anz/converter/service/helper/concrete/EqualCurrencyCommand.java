package com.anz.converter.service.helper.concrete;

import com.anz.converter.service.helper.ConversionCommand;

/*
 * When To and fromcurrency is same
 */
public class EqualCurrencyCommand implements ConversionCommand {

	public Double executeConversion(String from, String to) {
		return 1.0;
	}

	public static EqualCurrencyCommand getEqualCurrencyCommand() {
		return new EqualCurrencyCommand();
	}

}

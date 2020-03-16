package com.anz.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anz.converter.service.ConversionService;
import com.anz.converter.validator.Validator;

@Component
public class ConversionCommand implements CommandLineRunner {

	@Autowired
	ConversionService conversionService;

	@Override
	public void run(String... args) {

		if (Validator.validate(args)) {
			try {
				String value = conversionService.getCurrencyConversionValue(args[0], args[3], Double.valueOf(args[1]));

				if (value != null) {
					System.out.println(args[0] + " " + args[1] + " = " + args[3] + " " + value);
				} else {
					System.out.println("Unable to find rate for " + args[0] + "/" + args[3]);
				}
			} catch (Exception e) {
				System.out.println("Exception occured " + e);
			}
		} 
	}
}

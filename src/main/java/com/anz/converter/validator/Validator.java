package com.anz.converter.validator;

public class Validator {

	public static boolean validate(String... args) {
		try {
			if (args.length == 4 && null != args[0] && null != args[3] && null != args[1]
					&& Double.valueOf(args[1]) != null) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Exception in input " + e);
		}
		System.out.println("Wrong input ");
		return false;
	}

}

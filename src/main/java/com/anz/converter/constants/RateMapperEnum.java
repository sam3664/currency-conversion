package com.anz.converter.constants;

import java.util.HashMap;
import java.util.Map;

/*
 * Maps the from and to currency with its conversion rate
 */
public enum RateMapperEnum {
	AUDUSD(0.8371), CADUSD(0.8711), USDCNY(6.1715), EURUSD(1.2315), GBPUSD(1.5683), NZDUSD(0.7750), USDJPY(119.95),
	EURCZK(27.6028), EURDKK(7.4405), EURNOK(8.6651);

	 private static final Map<String, Double> rateMapperMap = new HashMap<String, Double>();
	 static {
	        for (RateMapperEnum rateMapperEnum : RateMapperEnum.values()) {
	        	rateMapperMap.put(rateMapperEnum.name(), rateMapperEnum.getMapperValue());
	        }
	    }
	private Double mapperValue;
	
	public static Map<String, Double> getRateMapperMap() {
		return rateMapperMap;
	}

	RateMapperEnum(Double mapperValue) {
		this.mapperValue = mapperValue;
	}


	public Double getMapperValue() {
		return mapperValue;
	}

}

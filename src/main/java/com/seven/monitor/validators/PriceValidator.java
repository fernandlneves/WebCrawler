package com.seven.monitor.validators;

/**
 * 
 * @author Usuario
 *
 */
public class PriceValidator {
	
	/**
	 * 
	 */
	private PriceValidator() {}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isRealPriceValid(String value) {
		
		try {
			Double.parseDouble(value.replaceAll("[R\\$ ]", "").replace(",", "."));
			return true;
		}catch (Exception e) {
			return false;	
		}
	}
}
package com.seven.monitor.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 * @author Usuario
 *
 */
public class CurrencyUtils {
	
	/**
	 * 
	 */
	private CurrencyUtils() {}
	
	/**
	 * 
	 */
	public static final String realCurrencyFormatted(String price) {
		
		try {
			NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			return format.format(Double.parseDouble(price));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return price;
	}
}
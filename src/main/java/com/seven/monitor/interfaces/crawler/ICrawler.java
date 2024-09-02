package com.seven.monitor.interfaces.crawler;

import java.util.List;
import java.util.Map;

import com.seven.monitor.interfaces.engine.IEngine;

/**
 * 
 * @author Usuario
 *
 */
public interface ICrawler<T> {

	/**
	 * 
	 */
	void observer();
	
	/**
	 * 
	 * @return String
	 */
	String name();
	
	/**
	 * 
	 * @return String
	 */
	String label();
	
	/**
	 * 
	 * @return
	 */
	String agent();

	/**
	 * 
	 * @return Map
	 */
	Map<String, String> observers();

	/**
	 * 
	 * @return
	 */
	List<String> keySelects();

	/**
	 * 
	 * @param value
	 * @return
	 */
	boolean isValid(String value);
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	T register(String name, String value);
	
	/**
	 * 
	 * @return
	 */
	IEngine<T> engine();
	
	/**
	 * 
	 * @return Map
	 */
	Map<String, T> products();
	
	/**
	 * 
	 * @return
	 */
	boolean isFormatted();
}
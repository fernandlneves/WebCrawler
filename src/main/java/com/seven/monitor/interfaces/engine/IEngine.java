package com.seven.monitor.interfaces.engine;

import com.seven.monitor.interfaces.crawler.ICrawler;

/**
 * 
 * @author Usuario
 *
 */
public interface IEngine<T> {

	/**
	 * 
	 */
	public void execute(ICrawler<T> crawler);
}
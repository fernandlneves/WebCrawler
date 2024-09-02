package com.seven.monitor.interfaces.crawler.watch;

import com.seven.monitor.interfaces.crawler.ICrawler;
import com.seven.monitor.model.domain.Watch;

/**
 * 
 * @author Usuario
 *
 */
public abstract class CrawlerWatch implements ICrawler<Watch> {

	/*
	 * 
	 */
	public void observer() {
		engine().execute(this);
	}

	/**
	 * 
	 */
	public Watch register(String name, String value) {
		return new Watch(name, value);
	}
}
package com.seven.monitor.interfaces.crawler.parfum;

import com.seven.monitor.interfaces.crawler.ICrawler;
import com.seven.monitor.model.domain.Parfum;

/**
 * 
 * @author Usuario
 *
 */
public abstract class CrawlerParfum implements ICrawler<Parfum> {

	/*
	 * 
	 */
	public void observer() {
		engine().execute(this);
	}

	/**
	 * 
	 */
	public Parfum register(String name, String value) {
		return new Parfum(name, value);
	}
}
package com.seven.monitor.model.business;

import static com.seven.monitor.utils.Constants.CRAWLER_LABEL;

import java.util.HashSet;
import java.util.Set;

import com.seven.monitor.interfaces.crawler.ICrawler;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Usuario
 *
 */
@Log4j2
public abstract class CrawlerBusiness<T> {

	private static final String DESCRIPTION = "%s: %s";

	/**
	 * 
	 * @param crawlers
	 */
	public void compare(Set<ICrawler<T>> crawlers) {

		crawlers.forEach(ICrawler::observer);

		Set<String> productKeys = new HashSet<>();
		crawlers.forEach(c -> productKeys.addAll(c.products().keySet()));

		productKeys.forEach(p -> {
			log.info((String.format(CRAWLER_LABEL, label() , p)));
			crawlers.forEach(c -> {
				if (c.products().containsKey(p))
					log.info(String.format(DESCRIPTION, c.label(), display(c.products().get(p))));
			});
		});
	}

	/**
	 * 
	 */
	public abstract String display(T t);
	
	/**
	 * 
	 */
	public abstract String label();
}
package com.seven.monitor.interfaces.engine.impl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.seven.monitor.interfaces.crawler.ICrawler;
import com.seven.monitor.interfaces.engine.IEngine;
import com.seven.monitor.utils.CurrencyUtils;
import com.seven.monitor.utils.WebCrawlerUtils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Usuario
 *
 */
@Log4j2
@AllArgsConstructor
@Service
public class HyperTextEngine<T> implements IEngine<T> {

	/*
	 * 
	 */
	@Override
	public void execute(ICrawler<T> crawler) {

		log.info("\nExtracting from {}. ", crawler.name());
		for (String productKey : crawler.observers().keySet()) {
			Document document = WebCrawlerUtils.getDocumentByUrl(crawler.observers().get(productKey), crawler.agent());

			if (document == null)
				continue;

			boolean found = false;
			for (String keyword : crawler.keySelects()) {
				Elements elements = WebCrawlerUtils.findElementsByDocumentAndKey(document, keyword);

				if (!isValid(found, elements))
					continue;

				for (Element element : elements) {

					if (isValid(crawler, found, element)) {
						found = true;
						
						String formattedPrice = getFormattedPrice(crawler, element);
						crawler.products().put(productKey, crawler.register(productKey, formattedPrice));
					}
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private String getFormattedPrice(ICrawler<T> crawler, Element element) {
		return (crawler.isFormatted()) ? element.text() : CurrencyUtils.realCurrencyFormatted(element.text());
	}
	
	/**
	 * 
	 */
	private boolean isValid(boolean found, Elements elements) {
		return found || elements.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
	}

	/**
	 * 
	 */
	private boolean isValid(ICrawler<T> crawler, boolean found, Element element) {
		return found || element == null || !crawler.isValid(element.text()) ? Boolean.FALSE : Boolean.TRUE;
	}
}
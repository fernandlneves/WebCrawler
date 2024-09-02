package com.seven.monitor.interfaces.engine.impl;

import org.apache.commons.lang3.StringUtils;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import com.seven.monitor.interfaces.crawler.ICrawler;
import com.seven.monitor.interfaces.engine.IEngine;
import com.seven.monitor.utils.CurrencyUtils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Usuario
 *
 * @param <T>
 */
@Log4j2
@AllArgsConstructor
@Service
public class ScrapeEngine<T> implements IEngine<T> {

	private WebClient webClient;

	/*
	 * 
	 */
	@Override
	public void execute(ICrawler<T> crawler) {

		log.info("\nExtracting from {}. ", crawler.name());

		try {
			for (String productKey : crawler.observers().keySet()) {
				HtmlPage document = webClient.getPage(crawler.observers().get(productKey));

				if (document == null)
					continue;

				String texto = document.asXml();
				for (String keyword : crawler.keySelects()) {
					String price = StringUtils.substringBetween(texto, keyword, ",");

					if (isValid(crawler, price)) {
						
						String formattedPrice = (crawler.isFormatted()) ? price : CurrencyUtils.realCurrencyFormatted(price);
						crawler.products().put(productKey, crawler.register(productKey, formattedPrice));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private boolean isValid(ICrawler<T> crawler, String price) {
		return price == null || !crawler.isValid(price) ? Boolean.FALSE : Boolean.TRUE;
	}
}

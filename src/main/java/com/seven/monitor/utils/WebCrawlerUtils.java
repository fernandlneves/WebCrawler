package com.seven.monitor.utils;

import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author Usuario
 *
 */
public class WebCrawlerUtils {
	
	/**
	 * 
	 */
	private WebCrawlerUtils() {}

	/**
	 * @param url
	 * @return
	 */
	public static final Document getDocumentByUrl(String url, String agent) {

		try {
			return Jsoup.connect(url).userAgent(agent).timeout(0).header("Content-Type", "application/x-www-form-urlencoded").get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param document
	 * @param key
	 * @return
	 */
	public static final Element findElementByDocumentAndKey(Document document, String key) {

		try {
			return document.select(key).first();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param document
	 * @param keys
	 * @return
	 */
	public static final Element findElementByDocumentAndKeys(Document document, List<String> keys) {

		try {
			for (String key : keys) {
				Element element = findElementByDocumentAndKey(document, key);
				if (element != null)
					return element;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param document
	 * @param key
	 * @return
	 */
	public static final Elements findElementsByDocumentAndKey(Document document, String key) {

		try {
			return document.select(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Elements(Collections.emptyList());
	}
}

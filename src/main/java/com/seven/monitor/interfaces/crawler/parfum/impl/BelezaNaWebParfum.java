package com.seven.monitor.interfaces.crawler.parfum.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.seven.monitor.interfaces.crawler.parfum.CrawlerParfum;
import com.seven.monitor.interfaces.engine.IEngine;
import com.seven.monitor.interfaces.engine.impl.HyperTextEngine;
import com.seven.monitor.model.domain.Parfum;
import com.seven.monitor.validators.PriceValidator;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Usuario
 *
 */
@Service
@AllArgsConstructor
public class BelezaNaWebParfum extends CrawlerParfum {

	private Map<String, Parfum> products;
	private HyperTextEngine<Parfum> engine;

	/*
	 * 
	 */
	public String name() {
		return "Beleza na Web - PARFUM";
	}

	/*
	 * 
	 */
	public String label() {
		return "Beleza na Web";
	}

	/*
	 * 
	 */
	public String agent() {
		return "";
	}

	/**
	 * 
	 */
	public List<String> keySelects() {
		List<String> keys = new LinkedList<>();
		keys.add("div.nproduct-price-value");
		keys.add("div.item-price-value");
		keys.add("div.nproduct-price-value-redesign");
		return keys;
	}

	/*
	 * 
	 */
	public Map<String, String> observers() {

		Map<String, String> observer = new HashMap<>();

		observer.put("Dolce & Gabbana - Light Blue Masculino",
				"https://www.belezanaweb.com.br/light-blue-pour-homme-eau-intense-dolce-e-gabbana-eau-de-parfum-perfume-masculino/");
		observer.put("Azzaro - Pour Homme Masculino",
				"https://www.belezanaweb.com.br/azzaro-pour-homme-eau-de-toilette-perfume-masculino-50ml/");
		observer.put("Pacco Rabanne - One Million Masculino",
				"https://www.belezanaweb.com.br/1-million-parfum-paco-rabanne-eau-de-parfum-perfume-masculino-100ml/");
		
		return observer;
	}

	/*
	 * 
	 */
	public boolean isValid(String value) {
		return PriceValidator.isRealPriceValid(value);
	}

	/**
	 * 
	 */
	public Map<String, Parfum> products() {
		return products;
	}

	/**
	 * 
	 */
	@Override
	public IEngine<Parfum> engine() {
		return engine;
	}

	/**
	 * 
	 */
	public boolean isFormatted() {
		return Boolean.TRUE;
	}
}
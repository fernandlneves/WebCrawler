package com.seven.monitor.interfaces.crawler.watch.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.seven.monitor.interfaces.crawler.watch.CrawlerWatch;
import com.seven.monitor.interfaces.engine.IEngine;
import com.seven.monitor.interfaces.engine.impl.ScrapeEngine;
import com.seven.monitor.model.domain.Watch;
import com.seven.monitor.validators.PriceValidator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VivaraWatch extends CrawlerWatch {

	private Map<String, Watch> products;
	private ScrapeEngine<Watch> engine;

	/*
	 * 
	 */
	public String name() {
		return "Vivara - WATCH";
	}

	/*
	 * 
	 */
	public String label() {
		return "Vivara";
	}

	/*
	 * 
	 */
	public String agent() {
		return "Opera";
	}

	/**
	 * 
	 */
	public List<String> keySelects() {
		List<String> keys = new LinkedList<>();
		keys.add("\"lowPrice\":");
		keys.add("\"price\":");

		return keys;
	}

	/*
	 * 
	 */
	public Map<String, String> observers() {

		Map<String, String> observer = new HashMap<>();

		observer.put("Akium - Slim Masculino",
				"https://www.vivara.com.br/relogio-akium-slim-masculino-couro-marrom-ak00003013/p");
		observer.put("Festina - Solar Energy - Masculino",
				"https://www.vivara.com.br/relogio-festina-solar-energy-masculino-couro-azul-ft00003325/p");
		observer.put("MVMT - Couro Verde - Masculino",
				"https://www.vivara.com.br/relogio-mvmt-masculino-couro-verde-28000287-d-mv00000221/p");
		

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
	public Map<String, Watch> products() {
		return products;
	}

	/**
	 * 
	 */
	public IEngine<Watch> engine() {
		return engine;
	}
	
	/**
	 * 
	 */
	public boolean isFormatted() {
		return Boolean.FALSE;
	}
}
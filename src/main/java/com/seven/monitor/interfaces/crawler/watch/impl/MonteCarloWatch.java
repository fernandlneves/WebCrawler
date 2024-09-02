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
public class MonteCarloWatch extends CrawlerWatch{
	
	private Map<String, Watch> products;
	private ScrapeEngine<Watch> engine;

	/*
	 * 
	 */
	public String name() {
		return "Monte Carlo - WATCH";
	}

	/*
	 * 
	 */
	public String label() {
		return "Monte Carlo";
	}

	/*
	 * 
	 */
	public String agent() {
		return "Chrome";
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

		observer.put("Fossil - Avermelhado Masculino",
				"https://www.montecarlo.com.br/relogios-fossilfossil-nim030839/p");	
		observer.put("Emporio Armani - Branco/Vermelho Masculino",
				"https://www.montecarlo.com.br/relogio-e-armaniemporio-armani-nim030546/p");
		observer.put("Victorinox - Alliance Sport Masculino",
				"https://www.montecarlo.com.br/victorinoxvictorinox-nim019878/p");
		
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

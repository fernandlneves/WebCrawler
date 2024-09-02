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
public class CasaPerfumesParfum extends CrawlerParfum{
	
	private Map<String, Parfum> products;
	private HyperTextEngine<Parfum> engine;

	/*
	 * 
	 */
	public String name() {
		return "Casa dos Perfumes - PARFUM";
	}
	
	/*
	 * 
	 */
	public String label() {
		return "Casa dos Perfumes";
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
		keys.add("div.js-price-display");
		
		return keys;
	}

	/*
	 * 
	 */
	public Map<String, String> observers() {

		Map<String, String> observer = new HashMap<>();

		observer.put("Giorgio Armani - Acqua de Gio",
				"https://www.casadosperfumesimportados.com.br/produtos/perfume-acqua-di-gio-giorgio-armani-masculino-eau-de-toilette/");
		observer.put("Pacco Rabanne - One Million Masculino",
				"https://www.casadosperfumesimportados.com.br/produtos/1-million-masculino-eau-de-toilette/");

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
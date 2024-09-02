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
public class SephoraParfum extends CrawlerParfum {

	private Map<String, Parfum> products;
	private HyperTextEngine<Parfum> engine;

	/*
	 * 
	 */
	public String name() {
		return "Sephora - PARFUM";
	}

	/*
	 * 
	 */
	public String label() {
		return "Sephora";
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
		keys.add("span.price-min");
		keys.add("span.price-sales");

		return keys;
	}

	/*
	 * 
	 */
	public Map<String, String> observers() {

		Map<String, String> observer = new HashMap<>();

		observer.put("Dolce & Gabbana - Light Blue Masculino",
				"https://www.sephora.com.br/perfume-light-blue-intense-pour-homme-masculino-eau-de-toilette-prd25855-12645.html");
		observer.put("Ralph Lauren - Polo Black",
				"https://www.sephora.com.br/perfume-ralph-lauren-polo-black-masculino-eau-de-toilette-PRD03426-PRD03426.html");
		observer.put("Giorgio Armani - Acqua de Gio",
				"https://www.sephora.com.br/perfume-armani-acqua-di-gio-masculino-eau-de-parfum-9090580511-9090580511.html");
		observer.put("Bvlgari - Main in Black",
				"https://www.sephora.com.br/bvlgari-man-in-black-masculino-eau-de-parfum-18955-8366.html");
		observer.put("MontBlanc - Individuel",
				"https://www.sephora.com.br/individuel-masculino-eau-de-toilette-1869-PRD01869.html");
		observer.put("Carolina Herrera - 212 Sexy Men",
				"https://www.sephora.com.br/on/demandware.store/Sites-Sephora_BR-Site/pt_BR/Product-Variation?pid=146387");
		observer.put("Dolce & Gabbana - Light Blue Feminino",
				"https://www.sephora.com.br/perfume-light-blue-intense-feminino-eau-de-toilette-prd25854-PRD25854.html");
		observer.put("Pacco Rabanne - One Million Masculino",
				"https://www.sephora.com.br/rabanne-1-million-edt-30ml-400335.html");

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
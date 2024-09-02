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

@Service
@AllArgsConstructor
public class EpocaCosmeticosParfum extends CrawlerParfum{
	
	private Map<String, Parfum> products;
	private HyperTextEngine<Parfum> engine;
	
	/*
	 * 
	 */
	public String name() {
		return "Época Cosméticos - PARFUM";
	}
	
	/*
	 * 
	 */
	public String label() {
		return "Época";
	}
	
	/*
	 * 
	 */
	public String agent() {
		return "Opera";
	}
	
	/*
	 * 
	 */
	public Map<String, String> observers() {
		
		Map<String, String> observer = new HashMap<>();
		observer.put("Dolce & Gabbana - Light Blue Masculino",
				"https://www.epocacosmeticos.com.br/light-blue-pour-homme-dolce-gabanna-perfume-masculino-eau-intense/p");
		observer.put("Bvlgari - Main in Black",
				"https://www.epocacosmeticos.com.br/bvlgari-man-in-black-eau-de-parfum-bvlgari-perfume-masculino/p");
		observer.put("Carolina Herrera - 212 Sexy Men",
				"https://www.epocacosmeticos.com.br/212-sexy-men-eau-de-toilette-carolina-herrera-perfume-masculino/p");
		observer.put("MontBlanc - Individuel",
				"https://www.epocacosmeticos.com.br/individuel-eau-de-toilette-montblanc-perfume-masculino/p");
		observer.put("Ralph Lauren - Polo Black",
				"https://www.epocacosmeticos.com.br/polo-black-eau-de-toilette-ralph-lauren-perfume-masculino/p");
		observer.put("Giorgio Armani - Acqua de Gio",
				"https://www.epocacosmeticos.com.br/acqua-di-gio-homme-eau-de-toilette-giorgio-armani-perfume-masculino/p");
		observer.put("Dolce & Gabbana - Light Blue Feminino",
				"https://www.epocacosmeticos.com.br/light-blue-pour-femme-dolce-gabanna-perfume-feminino-eau-intense/p");
		observer.put("Coach - Blue Coach Masculino",
				"https://www.epocacosmeticos.com.br/blue-coach-perfume-masculino-edt/p");
		observer.put("Pacco Rabanne - One Million Masculino",
				"https://www.epocacosmeticos.com.br/1-million-paco-rabanne-perfume-masculino-edp/p");
		
		return observer;
	}
	
	/*
	 * 
	 */
	public List<String> keySelects() {
		List<String> keys = new LinkedList<>();
		keys.add("strong.skuPrice");
		
		return keys;
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
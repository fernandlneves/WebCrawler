package com.seven.monitor.interfaces.crawler.car;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.seven.monitor.interfaces.engine.IEngine;
import com.seven.monitor.interfaces.engine.impl.HyperTextEngine;
import com.seven.monitor.model.domain.Car;
import com.seven.monitor.validators.PriceValidator;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Usuario
 *
 */
@Service
@AllArgsConstructor
public class AutoSerraCar extends CrawlerCar {

	private Map<String, Car> products;
	private HyperTextEngine<Car> engine;

	/*
	 * 
	 */
	public String name() {
		return "Auto Serra - CAR";
	}

	/*
	 * 
	 */
	public String label() {
		return "Auto Serra";
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
		keys.add("div.DetalhePreco");
		keys.add("div.ValorVeiculo");

		return keys;
	}

	/*
	 * 
	 */
	public Map<String, String> observers() {

		Map<String, String> observer = new HashMap<>();

		observer.put("Nissan Tiida - 2013 - Automático",
				"https://www.autoserra.com.br/comprar/carro/nissan/tiida/18-sl-16v-flex-4p-automatico/4-portas/2013/100807/");

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
	public Map<String, Car> products() {
		return products;
	}

	/**
	 * 
	 */
	@Override
	public IEngine<Car> engine() {
		return engine;
	}

	/**
	 * 
	 */
	public boolean isFormatted() {
		return Boolean.TRUE;
	}
}
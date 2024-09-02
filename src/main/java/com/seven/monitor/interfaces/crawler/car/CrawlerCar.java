package com.seven.monitor.interfaces.crawler.car;

import com.seven.monitor.interfaces.crawler.ICrawler;
import com.seven.monitor.model.domain.Car;

/**
 * 
 * @author Usuario
 *
 */
public abstract class CrawlerCar implements ICrawler<Car> {

	/*
	 * 
	 */
	public void observer() {
		engine().execute(this);
	}

	/**
	 * 
	 */
	public Car register(String name, String value) {
		return new Car(name, value);
	}
}
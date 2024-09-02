package com.seven.monitor.model.business;

import org.springframework.stereotype.Service;

import com.seven.monitor.model.domain.Car;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Usuario
 *
 */
@Service
@AllArgsConstructor
public class CarBusiness extends CrawlerBusiness<Car> {
	
	/**
	 * 
	 */
	@Override
	public String display(Car car) {
		return car.price();
	}
	
	/**
	 * 
	 */
	@Override
	public String label() {
		return "CAR";
	}
}
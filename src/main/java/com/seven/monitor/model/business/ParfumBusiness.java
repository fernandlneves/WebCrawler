package com.seven.monitor.model.business;

import org.springframework.stereotype.Service;

import com.seven.monitor.model.domain.Parfum;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Usuario
 *
 */
@Service
@AllArgsConstructor
public class ParfumBusiness extends CrawlerBusiness<Parfum> {
	
	/**
	 * 
	 */
	@Override
	public String display(Parfum parfum) {
		return parfum.price();
	}
	
	/**
	 * 
	 */
	@Override
	public String label() {
		return "PARFUM";
	}
}
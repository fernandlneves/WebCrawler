package com.seven.monitor.model.business;

import org.springframework.stereotype.Service;

import com.seven.monitor.model.domain.Watch;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WatchBusiness extends CrawlerBusiness<Watch> {
	
	/**
	 * 
	 */
	@Override
	public String display(Watch watch) {
		return watch.price();
	}
	
	/**
	 * 
	 */
	@Override
	public String label() {
		return "WATCH";
	}
}
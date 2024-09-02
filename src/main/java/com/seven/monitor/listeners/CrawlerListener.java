package com.seven.monitor.listeners;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seven.monitor.interfaces.crawler.ICrawler;
import com.seven.monitor.interfaces.crawler.car.CrawlerCar;
import com.seven.monitor.interfaces.crawler.parfum.CrawlerParfum;
import com.seven.monitor.interfaces.crawler.watch.CrawlerWatch;
import com.seven.monitor.model.domain.Car;
import com.seven.monitor.model.domain.Parfum;
import com.seven.monitor.model.domain.Watch;

@SuppressWarnings("rawtypes")
@Component
public class CrawlerListener {

	private Set<ICrawler> listeners;
	
	/**
	 * 
	 * @param listeners
	 */
	@Autowired
	public CrawlerListener(Set<ICrawler> listeners) {
		subscribe(listeners);
	}
	
	/**
	 * 
	 * @param listeners
	 */
	private void subscribe(Set<ICrawler> listeners) {
		this.listeners = listeners;
	}

	/**
	 * 
	 * @return
	 */
	
	public Set<ICrawler> getListeners() {
		return listeners;
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<ICrawler<Parfum>> getParfumListeners() {
		return listeners.stream().filter(CrawlerParfum.class::isInstance).collect(Collectors.toSet());
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<ICrawler<Watch>> getWatchListeners() {
		return listeners.stream().filter(CrawlerWatch.class::isInstance).collect(Collectors.toSet());
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<ICrawler<Car>> getCarListeners() {
		return listeners.stream().filter(CrawlerCar.class::isInstance).collect(Collectors.toSet());
	}
}

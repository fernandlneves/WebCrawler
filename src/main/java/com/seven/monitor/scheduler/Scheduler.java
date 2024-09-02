package com.seven.monitor.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.seven.monitor.listeners.CrawlerListener;
import com.seven.monitor.model.business.CarBusiness;
import com.seven.monitor.model.business.ParfumBusiness;
import com.seven.monitor.model.business.WatchBusiness;

import lombok.AllArgsConstructor;

/*
 * 
 */

@Component
@AllArgsConstructor
public class Scheduler {

	private ParfumBusiness pBusiness;
	private WatchBusiness wBusiness;
	private CarBusiness cBusiness;
	private CrawlerListener listener;

	/**
	 * 
	 * @param args
	 */
	@Scheduled(cron = "0 0/1 * * * *")
	public void schedule() {
		pBusiness.compare(listener.getParfumListeners());
		wBusiness.compare(listener.getWatchListeners());
		cBusiness.compare(listener.getCarListeners());
	}
}
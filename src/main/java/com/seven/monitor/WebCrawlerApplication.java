package com.seven.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author Usuario
 *
 */
@SpringBootApplication
@EnableScheduling
public class WebCrawlerApplication {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		SpringApplication.run(WebCrawlerApplication.class, args);
	}
}
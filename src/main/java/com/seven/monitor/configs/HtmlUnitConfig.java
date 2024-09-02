package com.seven.monitor.configs;

import org.htmlunit.BrowserVersion;
import org.htmlunit.SilentCssErrorHandler;
import org.htmlunit.WebClient;
import org.htmlunit.javascript.SilentJavaScriptErrorListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HtmlUnitConfig {
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public WebClient webClient() {
		
		WebClient client = new WebClient(BrowserVersion.BEST_SUPPORTED);
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setPrintContentOnFailingStatusCode(false);
		client.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
		client.setCssErrorHandler(new SilentCssErrorHandler());
		client.waitForBackgroundJavaScript(5000);
		
		return client;
	}
}
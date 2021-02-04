package com.ofs.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonConfiguration {
	
	@Autowired
	private IClientConfig clientConfig;
	
	@Bean
	public IPing ribbonPing(IClientConfig clientConfig) {
		return new PingUrl();
	}
	
	@Bean
	public IRule ribbonRule(IClientConfig clientConfig) {
			return new AvailabilityFilteringRule();		
	}
}

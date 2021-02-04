package com.ofs.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ofs.poc.config.RibbonConfiguration;

import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(name = "bankclient", configuration = RibbonConfiguration.class)
public class OnlineFoodServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodServiceApplication.class, args);
	}

}

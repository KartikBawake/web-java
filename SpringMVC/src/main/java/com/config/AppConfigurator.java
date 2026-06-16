package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.controller"})
public class AppConfigurator {

	@Bean
	public ViewResolver vs() {
		System.out.println("Resolver registered");
		InternalResourceViewResolver vs = new InternalResourceViewResolver();
		vs.setPrefix("/WEB-INF/views/");
		vs.setSuffix(".jsp");
		return vs;
	}
	
}

package com.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringMVCInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfigurator.class);
		context.setServletContext(servletContext);
			
		ServletRegistration.Dynamic servletController = servletContext.addServlet("dispatcher",  new DispatcherServlet(context));
		servletController.setLoadOnStartup(1);
		servletController.addMapping("/spring/*");
		
	}

}

package com.Kartik.Spring_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.AppConfig.Config;
import com.Entity.Users;

public class App {
    public static void main(String[] args) {
        
    	try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);){
    		
    		Users objUser = (Users)context.getBean("objUser");
    		System.out.println(objUser);
    		
    	}
    	
    }
}

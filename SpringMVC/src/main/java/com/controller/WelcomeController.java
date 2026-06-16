package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		System.out.println("Welcome in welcome controller");
		return new ModelAndView("welcome", "message", "welcome to the first MVC app");
	}
	
}

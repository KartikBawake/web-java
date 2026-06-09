package org.Servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/CheckBrowser", 
				"/CheckInfo"})
public class CheckBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String browser = request.getHeader("user-agent");
		
		PrintWriter out = response.getWriter();
		
		if(browser.indexOf("FireFox") != -1) {
			out.println("You are using FireFox Browser");
		}
		else if(browser.indexOf("Edg") != -1) {
			out.println("You are using Microsoft Edge Browser");
		}
		else if(browser.indexOf("Chrome") != -1) {
			out.println("You are using Google Chrome Browser");
		}
		else {
			out.println("You are using an Unusual Browser: ");
		}
		
	}

}

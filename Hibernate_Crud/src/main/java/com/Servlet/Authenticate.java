package com.Servlet;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration cfg = new Configuration();
		cfg.configure("crud.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		User user = session.createQuery(
		        "from User where fname = :name and rollno = :roll",
		        User.class)
		    .setParameter("name", name)
		    .setParameter("roll", roll)
		    .uniqueResult();

		if(user != null) {
		    response.getWriter().println("Login Success");
		}
		else {
		    response.getWriter().println("Invalid Credentials");
		}

		session.close();
		sf.close();
	}

}

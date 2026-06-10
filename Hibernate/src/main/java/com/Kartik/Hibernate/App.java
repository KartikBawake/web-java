package com.Kartik.Hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Kartik.Entity.Users;

public class App {
    public static void main(String[] args) {
        
    	//It reads the XML config file which maps to the database.
    	Configuration cfg = new Configuration();
    	cfg.configure("Users.cfg.xml");
    	
    	//This creates database connections, like a pool of connections
    	SessionFactory sf = cfg.buildSessionFactory();
    	
    	//This gets one connection from that connection pool
    	//Session session = sf.openSession();
    	
    	try (Session session = sf.openSession();
    			Scanner sc = new Scanner(System.in);
    			){
			
    		System.out.print("Enter UserName: ");
    		String username = sc.next();
    		
    		System.out.print("Enter Password: ");
    		String password = sc.next();
    		
    		System.out.print("Enter Name: ");
    		String name = sc.next();
    		
    		System.out.print("Enter Email: ");
    		String email = sc.next();
    		
    		System.out.print("Enter City: ");
    		String city = sc.next();
    		
    		Users objUsers = new Users(username, password, name, email, city);
    		
    		Transaction t = session.beginTransaction();
    		
    		//Adding users with Persist method
    		session.persist(objUsers);
    		System.out.println("Record Added!");
    		
    		//Fetching info of a user from database with Find method
    		Users objUsers2 = session.find(Users.class, "ban");
    		t.commit();
    		
    		
    		
    		System.out.println(objUsers2.getName());
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}

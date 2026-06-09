package com.Kartik;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC_Connectivity {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try(FileReader fr = new FileReader("src/com/Kartik/Application.properties");){
			
			prop.load(fr);
			
			String url = prop.getProperty("URL");
			String username = prop.getProperty("USERNAME");
			String pass = prop.getProperty("PASSWORD");
		
			try(Connection connection = DriverManager.getConnection(url, username, pass);
					Scanner sc = new Scanner(System.in);){
				
				System.out.println(connection);
				System.out.println("Connection Successful!");
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		catch (FileNotFoundException e) {
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}

		

	}

}

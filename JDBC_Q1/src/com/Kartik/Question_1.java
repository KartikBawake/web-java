package com.Kartik;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Question_1 {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try(FileReader fr = new FileReader("src/Application.properties");){
			
			prop.load(fr);
			
			String url = prop.getProperty("URL");
			String username = prop.getProperty("USERNAME");
			String pass = prop.getProperty("PASSWORD");
		
			try(Connection connection = DriverManager.getConnection(url, username, pass);
					Scanner sc = new Scanner(System.in);){
				
				connection.setAutoCommit(false);
				System.out.println(connection);
				System.out.println("Connection Successful!");
				
				boolean loop = true;
				while(loop) {
				
					System.out.println("------------Menu-----------");
					System.out.println("1) Register a User");
					System.out.println("2) List Users based on City");
					System.out.println("3) Update Password of a User");
					System.out.println("4) Display UserInfo based on Username");
					System.out.println("5) Exit");
					
					int choice = sc.nextInt();
					sc.nextLine();
					
					switch (choice) {
					case 1:
						registerUser(sc, connection);
						break;
					case 2:
						listUserBasedOnCity(sc, connection);
						break;
					case 3:
						updatePasswordOfUser(sc, connection);
						break;
					case 4:
						displayUserInfoBasedOnUsername(sc, connection);
						break;
					case 5:
						System.out.println("Exited...");
						loop = false;
						break;

					default:
						System.out.println("Invalid Choice");
						System.out.println("Enter the Correct Choice.");
					}
				}
				
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

	private static void displayUserInfoBasedOnUsername(Scanner sc, Connection connection) {
		
		try(PreparedStatement ps = connection.prepareStatement("select * from user where username = ?");
				) {
			
			System.out.print("Enter Username:");
			String username = sc.nextLine();
			
			ps.setString(1, username);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
				}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updatePasswordOfUser(Scanner sc, Connection connection) {
		
		try(PreparedStatement ps = connection.prepareStatement("UPDATE user SET password = ? WHERE username = ?")){
			
	        System.out.print("Enter Username: ");
	        String username = sc.nextLine();

	        System.out.print("Enter Password: ");
	        String password = sc.nextLine();
	        
	        ps.setString(1, password);
	        ps.setString(2, username);
	        
			ps.executeUpdate();
			connection.commit();
			
			System.out.println("User Password Updated\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void listUserBasedOnCity(Scanner sc, Connection connection) {
		
		try(PreparedStatement ps = connection.prepareStatement("select * from user where city = ?");
				) {
			
			System.out.print("Enter City:");
			String city = sc.nextLine();
			
			ps.setString(1, city);
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
				}
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void registerUser(Scanner sc, Connection connection) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("Insert into user values(?, ?, ?, ?, ?)");
			
	        System.out.print("Enter Username: ");
	        String username = sc.nextLine();

	        System.out.print("Enter Password: ");
	        String password = sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();
	        
	        System.out.print("Enter City: ");
	        String city = sc.nextLine();
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, city);
			
			ps.executeUpdate();
			connection.commit();
			
			System.out.println("Used Registered\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

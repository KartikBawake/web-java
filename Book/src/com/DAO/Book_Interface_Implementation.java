package com.DAO;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Book_Interface_Implementation implements Book_Interface {

	Connection con;
	private PreparedStatement addBook;
	private PreparedStatement removeBook;
	private PreparedStatement getBookDetails;
	private PreparedStatement getBookPrice;
	Scanner sc = new Scanner(System.in);
	
	public Book_Interface_Implementation() {
				
		Properties props = new Properties();
		
		try (FileReader fr = new FileReader("src/com/DAO/application.properties")){
			props.load(fr);
			String url = props.getProperty("URL");
			String username = props.getProperty("USER");
			String password = props.getProperty("PASS");
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
			System.out.println("Connection Successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean add_Book(Book b) throws Book_Custom_Exception {
		
		try {
			addBook = con.prepareStatement("insert into book values(?, ?, ?, ?)");
			
			addBook.clearParameters();
			addBook.setString(1, b.getName());
			addBook.setString(2, b.getDescription());
			addBook.setInt(3, b.getPrice());
			addBook.setInt(4, b.getRating());
			addBook.executeUpdate();
			
			System.out.println("Book Added");
			return true;
	
		} catch (SQLException e) {
			throw new Book_Custom_Exception(e.getMessage());
		}
	}

	@Override
	public boolean delete_Book(String username) throws Book_Custom_Exception {
		
		try {
			removeBook = con.prepareStatement("DELETE FROM book WHERE name = ?");
			
			removeBook.clearParameters();
			removeBook.setString(1, username);
			removeBook.executeUpdate();
			
			System.out.println("Book Removed");
			return true;
			
		} catch (SQLException e) {
			throw new Book_Custom_Exception(e.getMessage());
		}
			
	}

	@Override
	public Book get_book_Details(String bookname) throws Book_Custom_Exception {
		
		try {
			getBookDetails = con.prepareStatement("select * from book where name = ?");
			getBookDetails.setString(1, bookname);
			
			try(ResultSet result = getBookDetails.executeQuery()) {
				if (result.next()) {
					Book b = new Book();
					b.setName(bookname);
					b.setDescription(result.getString(2));
					b.setPrice(result.getInt(3));
					b.setRating(result.getInt(4));
					return b;
				}
			}
			
		} catch (SQLException e) {
			throw new Book_Custom_Exception(e.getMessage());
		}
		return null;
	}

	@Override
	public Book get_Book_Price(String bookname) throws Book_Custom_Exception {
		
		try {
			getBookPrice = con.prepareStatement("select price from book where name = ?");
			getBookPrice.setString(1, bookname);
			
			try(ResultSet result = getBookPrice.executeQuery()) {
				if (result.next()) {
					Book b = new Book();
					b.setName(bookname);
					b.setPrice(result.getInt(1));
					return b;
				}
			}
			
		} catch (SQLException e) {
			throw new Book_Custom_Exception(e.getMessage());
		}
		return null;
	}
}

package com.DAO;

public interface Book_Interface {

	public boolean add_Book(Book b) throws Book_Custom_Exception;
	public boolean delete_Book(String bookname) throws Book_Custom_Exception;
	public Book get_book_Details(String bookname) throws Book_Custom_Exception;
	public Book get_Book_Price(String bookname) throws Book_Custom_Exception;
	
}

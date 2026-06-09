package com.DAO;

public class Entry {

	public static void main(String[] args) throws Book_Custom_Exception {
		
		Book_Interface_Implementation bii = new Book_Interface_Implementation();
		
//Adding A Book in Database
//		Book b = new Book();
//		b.setName("Harry Porter");
//		b.setDescription("Its about Wizards and Sorcerers");
//		b.setPrice(1650);
//		b.setRating(5);
//		Book b1 = new Book();
//		b1.setName("Alice in Wonderland");
//		b1.setDescription("Its about Magical World");
//		b1.setPrice(1200);
//		b1.setRating(4);
//		bii.add_Book(b);
//		bii.add_Book(b1);
		
//Delete A Book in Database
//		bii.delete_Book("Harry Porter");
		
//Get Book Details from Database
//		Book details = bii.get_book_Details("Alice in Wonderland");
//		System.out.println(details.name);
//		System.out.println(details.description);
//		System.out.println(details.price);
//		System.out.println(details.rating);
		
//Get Book Price from Database
		Book bookprice = bii.get_book_Details("Harry Porter");
		System.out.println(bookprice.price);

	}

}

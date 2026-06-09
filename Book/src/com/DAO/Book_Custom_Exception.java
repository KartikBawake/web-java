package com.DAO;

@SuppressWarnings("serial")
public class Book_Custom_Exception extends Exception {

    public Book_Custom_Exception() {
        super();
    }

    public Book_Custom_Exception(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Book_Custom_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Book_Custom_Exception(String message) {
        super(message);
    }

    public Book_Custom_Exception(Throwable cause) {
        super(cause);
    }
	
}

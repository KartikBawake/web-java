package com.DTO;

public class TransactionDTO {
	
	private int cardNumber;
	private String company;
	private String date;
	private String time;
	private String status;
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransactionDTO [ CardNumber=" + cardNumber + ", Company=" + company + ", Date=" + date + ", Time=" + time
				+ ", Status=" + status + " ]";
	}
	
	

}

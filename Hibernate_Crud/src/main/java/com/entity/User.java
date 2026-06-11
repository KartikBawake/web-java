package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
@NamedQueries({@NamedQuery(name = "allStudents",
						query="from User",
						resultClass = User.class)})
public class User {

	@Id
	@Column(name="rollno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int roll;
	
	@Column(name="firstname")
	String fname;
	
	@Column(name="lastname")
	String lname;	
	
	@Column(name="marks")
	int marks;

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public User(int roll, String fname, String lname, int marks) {
		super();
		this.roll = roll;
		this.fname = fname;
		this.lname = lname;
		this.marks = marks;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User - [ roll=" + roll + ", fname=" + fname + ", lname=" + lname + ", marks=" + marks + " ]";
	}
	
}

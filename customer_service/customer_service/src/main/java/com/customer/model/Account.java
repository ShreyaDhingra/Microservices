package com.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@Column(unique = true)
	private long accNo;
	private double balance;
	private long userID;

	//Constructor
	public Account(long accNo, double balance, long userID) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.userID = userID;
	}
	public Account() {
		
	}
	
	//Getters and Setters
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	

}

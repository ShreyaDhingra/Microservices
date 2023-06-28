package com.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@Column(unique = true)
	private Long accNo;
	private double balance;
	private Long userID;

	//Constructor
	public Account(Long accNo, double balance, Long userID) {
		//super();
		this.accNo = accNo;
		this.balance = balance;
		this.userID = userID;
	}
	public Account() {
		
	}
	
	//Getters and Setters
	public Long getAccNo() {
		return accNo;
	}
	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	

}

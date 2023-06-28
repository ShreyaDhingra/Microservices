package com.customer.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.Query;
import org.hibernate.Session;




@SuppressWarnings("deprecation")
@Entity
public class Customer {
	@Id
	@Column(unique = true)
	private Long userID;
	private String name;
	private Long phoneNumber;
	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userID")
	List<Account> accounts ;
	
	//Constructors
	public Customer(Long userID, String name, Long phoneNumber, List<Account> accounts) {
		super();
		this.userID = userID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.accounts = accounts;
	}
	public Customer(Long userID, String name, Long phoneNumber) {
		super();
		this.userID = userID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public Customer() {
		
	}
	//Getter and setter
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Account> getAccounts() {
		return accounts;
		
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	

}

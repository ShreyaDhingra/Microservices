package com.customer.service;

import java.util.List;
import java.util.Optional;

import com.customer.model.Customer;

public interface CustomerService {
	//Get Customer details by Customer ID
	Customer getCustomer(Long id);
	
	//Get all customers
	List<Customer> getAllCustomers();
	
	//Add customer
	void addCustomer(Customer cust);
	
	//Update customer
	void updateCustomer(Customer cust, Long id);
	
	//DeleteCustomer
	void deleteCustomer(Long id);
	

	
	
	
	

}

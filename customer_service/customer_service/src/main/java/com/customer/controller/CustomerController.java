package com.customer.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.model.Account;
import com.customer.model.Customer;
import com.customer.service.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Get user by User ID
	@GetMapping("/{userID}")
	public Customer getCustomer(@PathVariable("userID") Long userId) {
		Customer customer = this.customerService.getCustomer(userId);
		return customer;
	}
	
	// Add new customer
    @PostMapping("/")
    public void addCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
    }

    // Update customer by User ID
    @PutMapping("/{userID}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable("userID") Long userId) {
        this.customerService.updateCustomer(customer, userId);
    }
    
 // Delete customer by User ID
    @DeleteMapping("/{userID}")
    public void deleteCustomer(@PathVariable("userID") Long userId) {
        this.customerService.deleteCustomer(userId);
        this.restTemplate.delete("http://account-service/account/customer/" +userId);
    }
}

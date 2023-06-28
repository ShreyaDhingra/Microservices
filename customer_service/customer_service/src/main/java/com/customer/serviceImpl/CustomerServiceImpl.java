package com.customer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repo.CustomerRepo;
import com.customer.service.CustomerService;
import com.customer.exception.ResourceNotFound;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo custRepo;

	public List<Customer> customer;
	
	@Override
	public Customer getCustomer(Long id) {
		return custRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "id", id));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

	@Override
    public void addCustomer(Customer cust) {
         custRepo.save(cust);
    }

	@Override
    public void updateCustomer(Customer cust, Long id) {
        Customer existingCust = custRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "id", id));
        existingCust = cust;
        custRepo.save(existingCust);
    }

	@Override
    public void deleteCustomer(Long id) {
		custRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "id", id));
        custRepo.deleteById(id);
	}
	
	
	
}

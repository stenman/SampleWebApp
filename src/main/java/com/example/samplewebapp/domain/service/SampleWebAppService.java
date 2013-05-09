package com.example.samplewebapp.domain.service;

import java.util.List;

import com.example.samplewebapp.domain.model.Customer;

public interface SampleWebAppService {
	public int fetchCustomerCount();
	
	public Customer fetchCustomer(int id);
	
	public List<Customer> fetchAllCustomers();
	
	public void addCustomer(Customer customer);
}

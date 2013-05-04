package com.example.samplewebapp.service;

import java.util.List;

import com.example.samplewebapp.domainmodel.Customer;

public interface SampleWebAppService {
	public int fetchCustomerCount();
	
	public String fetchCustomerFirstName(int id);
	
	public Customer fetchCustomer(int id);
	
	public List<Customer> fetchAllCustomers();
	
	public void addCustomer(Customer customer);
}

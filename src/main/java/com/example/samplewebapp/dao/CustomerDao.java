package com.example.samplewebapp.dao;

import java.util.List;

import com.example.samplewebapp.domainmodel.Customer;

public interface CustomerDao {
	public int getCustomerCount();
	public Customer getCustomer(int id);
	public String getCustomerFirstName(int id);
	public List<Customer> getAllCustomers();
	public void insertCustomer(Customer customer);
}

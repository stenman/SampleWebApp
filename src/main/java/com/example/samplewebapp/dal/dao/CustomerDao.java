package com.example.samplewebapp.dal.dao;

import java.util.List;

import com.example.samplewebapp.domain.model.Customer;

public interface CustomerDao {
	public int getCustomerCount();
	public Customer getCustomer(int id);
	public String getCustomerFirstName(int id);
	public List<Customer> getAllCustomers();
	public void insertCustomer(Customer customer);
}

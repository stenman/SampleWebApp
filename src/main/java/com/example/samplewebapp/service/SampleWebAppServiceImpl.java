package com.example.samplewebapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.samplewebapp.domainmodel.Customer;

@Service
public class SampleWebAppServiceImpl implements SampleWebAppService{

	@Inject
	private Customer customer;

	@Override
	public int fetchCustomerCount() {
		return this.customer.getCustomerCount();
	}

	@Override
	public String fetchCustomerFirstName(int id) {
		return this.customer.getCustomerDescription(id);
	}

	@Override
	public Customer fetchCustomer(int id) {
		return this.customer.getCustomer(id);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		return this.customer.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		this.customer.insertCustomer(customer);
	}
}

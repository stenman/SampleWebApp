package com.example.samplewebapp.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.samplewebapp.dal.dao.CustomerDao;
import com.example.samplewebapp.domain.model.Customer;

@Service
public class SampleWebAppServiceImpl implements SampleWebAppService{

	@Inject
	private CustomerDao customerDao;

	@Override
	public int fetchCustomerCount() {
		return customerDao.getCustomerCount();
	}

	@Override
	public Customer fetchCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
	}
}

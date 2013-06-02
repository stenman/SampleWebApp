package com.example.samplewebapp.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samplewebapp.dal.dao.CustomerDao;
import com.example.samplewebapp.domain.model.Customer;

@Transactional
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

	//TODO: This transaction should be tested as a Unit-test, not in code!
	@Override
	public void addCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
		Customer customer1 = new Customer();
		customer1.setId(2001);
		customer1.setFirstName("John");
		customer1.setLastName("Petrucci");
		this.customerDao.insertCustomer(customer1);
	}
}

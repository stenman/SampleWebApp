package com.example.samplewebapp.domainmodel;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.samplewebapp.dao.CustomerDao;

@Service
public class Customer {

	private int id;
	private String firstName;
	private String lastName;

	public Customer(){}
	
	public Customer(int id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Inject
	private CustomerDao customerDao;
	
	public int getId(){
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getCustomerCount() {
		return customerDao.getCustomerCount();
	}

	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	public String getCustomerDescription(int id) {
		return customerDao.getCustomerFirstName(id);
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	public void insertCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
	}
}

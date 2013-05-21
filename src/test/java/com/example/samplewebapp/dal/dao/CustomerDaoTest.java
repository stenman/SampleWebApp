package com.example.samplewebapp.dal.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CustomerDaoTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore("Not Ready to Run")  
	@Test
	public void testGetCustomerCount() {
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		int actual = customerDaoImpl.getCustomerCount();
		int expected = -1;
		assertEquals(actual, expected);
	}

	@Ignore("Not Ready to Run")  
	@Test
	public void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Ignore("Not Ready to Run")  
	@Test
	public void testGetAllCustomers() {
		fail("Not yet implemented");
	}

	@Ignore("Not Ready to Run")  
	@Test
	public void testInsertCustomer() {
		fail("Not yet implemented");
	}

}

package com.example.samplewebapp.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.samplewebapp.dao.CustomerDaoImpl;
import com.example.samplewebapp.domainmodel.Customer;

public class TryGitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
        CustomerDaoImpl customerDao = ctx.getBean("customerDaoImpl", CustomerDaoImpl.class);
 
        System.out.println(customerDao.getCustomerCount());

        System.out.println(customerDao.getCustomerFirstName(1000));
        
//        Customer customer1 = customerDao.getCustomer(1001);
//        System.out.println(customer1.getId());
//        System.out.println(customer1.getFirstName());
//        System.out.println(customer1.getLastName());
//        
//        System.out.println(customerDao.getAllCustomers().size());
//        
//        customerDao.insertCustomer(new Customer(1005, "Karl-Gustaf", "Bernadotte"));
//        System.out.println(customerDao.getCustomerCount());
//        
//        customerDao.insertCustomer(new Customer(1006, "Victoria", "Bernadotte"));
//        System.out.println(customerDao.getCustomerCount());
        
        
	}

}

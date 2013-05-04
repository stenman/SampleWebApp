package com.example.samplewebapp.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.samplewebapp.dao.CustomerDaoImpl;
import com.example.samplewebapp.domainmodel.Customer;
import com.example.samplewebapp.service.SampleWebAppService;

public class SampleWebAppDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
        SampleWebAppService customer = ctx.getBean("sampleWebAppServiceImpl", SampleWebAppService.class);
 
        System.out.println(customer.fetchCustomerCount());

        System.out.println(customer.fetchCustomerFirstName(1000));
        
//        Customer customer1 = customer.fetchCustomer(1001);
//        System.out.println(customer1.getId());
//        System.out.println(customer1.getFirstName());
//        System.out.println(customer1.getLastName());
//        
//        System.out.println(customer.fetchAllCustomers().size());
//        
//        customer.addCustomer(new Customer(1009, "Ingemar", "Stenmark"));
//        System.out.println(customer.fetchCustomerCount());
//        
//        customer.addCustomer(new Customer(1010, "Björn", "Borg"));
//        System.out.println(customer.fetchCustomerCount());
	}

}

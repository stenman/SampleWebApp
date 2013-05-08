package com.example.samplewebapp.presentation.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.samplewebapp.domain.service.SampleWebAppService;
import com.example.samplewebapp.presentation.model.Customer;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("customer")
public class CustomerController {
	
	private SampleWebAppService sampleWebAppService;
	
	@Inject
	public void setSampleWebAppService(SampleWebAppService sampleWebAppService){
		this.sampleWebAppService = sampleWebAppService;
	}
		
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("customer")
                            Customer customer, BindingResult result) {
         
        System.out.println("First Name:" + customer.getFirstName() + 
                    "Last Name:" + customer.getLastName());
         
        return "redirect:customers.html";
    }
     
    @RequestMapping("/customers")
    public ModelAndView showContacts() {
         
        return new ModelAndView("customer", "command", new Customer());
    }
	
}

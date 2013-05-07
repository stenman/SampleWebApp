package com.example.samplewebapp.presentation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.samplewebapp.presentation.model.Customer;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class CustomerController {
	
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

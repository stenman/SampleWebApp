package com.example.samplewebapp.presentation.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.samplewebapp.domain.model.Customer;
import com.example.samplewebapp.domain.service.SampleWebAppService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("customer")
public class CustomerController {
	
	//TODO: REMOVE THIS! TESTING THE CONTROLLER

	private SampleWebAppService sampleWebAppService;
	
	@Inject
	public void setSampleWebAppService(SampleWebAppService sampleWebAppService){
		this.sampleWebAppService = sampleWebAppService;
	}	
	
	@RequestMapping(value="/customer1", method=RequestMethod.GET)
	public String sayHello(ModelMap model){
		model.addAttribute("message1", "Hello!!!");
		return "home";
	}

	@RequestMapping(value="/customer2", method=RequestMethod.GET)
	public String showCustomer(@RequestParam("lbl_name") int customerId, ModelMap model){
		
		Customer customer = sampleWebAppService.fetchCustomer(customerId);
		
		model.addAttribute("message2", customer.getFirstName() + " " + customer.getLastName());

		return "home";
	}
	
	//TODO: REMOVE THIS! TESTING THE CONTROLLER
	
	
	
//	private SampleWebAppService sampleWebAppService;
//	
//	@Inject
//	public void setSampleWebAppService(SampleWebAppService sampleWebAppService){
//		this.sampleWebAppService = sampleWebAppService;
//	}
//		
//    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
//    public String addContact(@ModelAttribute("customer")
//                            Customer customer, BindingResult result) {
//         
//        System.out.println("First Name:" + customer.getFirstName() + 
//                    "Last Name:" + customer.getLastName());
//         
//        return "redirect:customers.html";
//    }
//     
//    @RequestMapping("/customers")
//    public ModelAndView showContacts() {
//         
//        return new ModelAndView("customer", "command", new Customer());
//    }
	
}

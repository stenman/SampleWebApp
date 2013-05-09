package com.example.samplewebapp.presentation.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.samplewebapp.domain.model.Customer;
import com.example.samplewebapp.domain.service.SampleWebAppService;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes("customer")
@Controller
public class CustomerController {

	private SampleWebAppService sampleWebAppService;

	@Inject
	public void setSampleWebAppService(SampleWebAppService sampleWebAppService) {
		this.sampleWebAppService = sampleWebAppService;
	}

	@RequestMapping(value = "/customer1", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("message1", "Hello!!!");
		return "home";
	}

	@RequestMapping(value = "/customer2", method = RequestMethod.GET)
	public String showCustomer(@RequestParam("lbl_name") int customerId,
			ModelMap model) {

		Customer customer = sampleWebAppService.fetchCustomer(customerId);

		model.addAttribute("message2",
				customer.getFirstName() + " " + customer.getLastName());

		return "home";
	}

	// @ModelAttribute("customer")
	// public Customer getCustomer() {
	// return new Customer();
	// }

	//TODO: Try finding a better way of mapping the "landing page"
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showCustomerForm(ModelMap model) {
		model.addAttribute("customer", new Customer());
		return "home";
	}

	@RequestMapping(value = "/customer3", method = RequestMethod.POST)
	public String onSubmitCustomerForm(
			@ModelAttribute("customer") Customer customer,
			BindingResult result, ModelMap model) {

		 sampleWebAppService.addCustomer(customer);
		 model.addAttribute("customer", customer);
		 model.addAttribute("message3", "Customer Added!");

		return "home";
	}
}

package com.example.samplewebapp.presentation.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

	@RequestMapping(method = RequestMethod.GET)
	public String handleRequest(Locale locale, ModelMap model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "firstpage_home";
	}

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("message1", "Hello!!!");
		return "firstpage_home";
	}

	@RequestMapping(value = "/getCustomerId", method = RequestMethod.GET)
	public String showCustomer(@RequestParam("lbl_name") int customerId, ModelMap model) {
		Customer customer = sampleWebAppService.fetchCustomer(customerId);
		model.addAttribute("message2", customer.getFirstName() + " " + customer.getLastName());
		return "firstpage_home";
	}

	@ModelAttribute("customer")
	public Customer getCustomerObject() {
		return new Customer();
	}

	@RequestMapping(value = "/customer3", method = RequestMethod.POST)
	public String onSubmitCustomerForm(@ModelAttribute("customer") Customer customer, BindingResult result,
			ModelMap model) {
		sampleWebAppService.addCustomer(customer);
		model.addAttribute("customer", customer);
		model.addAttribute("message3", "Customer Added!");
		return "firstpage_home";
	}
}

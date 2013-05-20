package com.example.samplewebapp.presentation.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SandboxController {

	@RequestMapping(value="/sandbox_entry", method = RequestMethod.GET)
	public String sandboxEntry(Locale locale, ModelMap model) {
		model.addAttribute("message", "Click the button to get the current local time: " );
		return "sandbox_home";
	}
	
	  @RequestMapping(value = "/sandbox_time", method = RequestMethod.GET)
	  public @ResponseBody String getTime(@RequestParam String name1, @RequestParam String name2) {
	    String result = "Time for " + name1 + " and " + name2 + " is " + new Date().toString();
	    return result;
	  }
}

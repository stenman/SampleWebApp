package com.example.samplewebapp.presentation.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SandboxController {

	@RequestMapping(value="/sandboxEntry", method = RequestMethod.GET)
	public String sandboxEntry(Locale locale, ModelMap model) {
		System.out.println("SandboxController/sandboxEntry");
		return "sandbox_home";
	}
}

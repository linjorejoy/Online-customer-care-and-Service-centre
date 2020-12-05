package com.cts.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Admin;
import com.cts.proj.model.Analyst;
import com.cts.proj.model.User;

@Controller
public class LoginController {
	
	

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public String userLogin(@Validated @ModelAttribute("user") User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user-login";
		}

		return "complaint-creation";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public String adminLogin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result) {

//		if (result.hasErrors()) {
//			return "admin-login";
//		}

		return "admin-login";
	}
	
	@RequestMapping(value = "/admin-login", method = RequestMethod.POST)
	public String adminAfterLogin(@Validated @ModelAttribute("analyst") Admin admin, BindingResult result,
			ModelMap model) {
		
		
		
		return "complaint-notification-admin";
	}

	@RequestMapping(value = "/analyst-login", method = RequestMethod.GET)
	public String analystLogin(@Validated @ModelAttribute("admin") Analyst analyst, BindingResult result) {

//		if (result.hasErrors()) {
//			return "analyst-login";
//		}

		return "analyst-login";
	}

	@RequestMapping(value = "/analyst-login", method = RequestMethod.POST)
	public String analystAfterLogin(@Validated @ModelAttribute("analyst") Analyst analyst, BindingResult result,
			ModelMap model) {
		
		
		
		return "complaint-notification-admin";
	}
	
}

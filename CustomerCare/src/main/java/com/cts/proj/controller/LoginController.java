package com.cts.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Admin;
import com.cts.proj.model.Analyst;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.User;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.validate.AdminPasswordValidator;
import com.cts.proj.validate.AnalystPasswordValidator;
import com.cts.proj.validate.UserPasswordValidator;

@Controller
public class LoginController {
	
	@Autowired
	ComplaintService complaintService;
	
	@Autowired
	UserPasswordValidator userPasswordValidator;
	
	@Autowired
	AnalystPasswordValidator analystPasswordValidator;
	
	@Autowired
	AdminPasswordValidator adminPasswordValidator;

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public String userLogin(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result) {
		return "user-login";
	}

	@RequestMapping(value = "/user-login", method = RequestMethod.POST)
	public String userAfterLogin(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result) {
		
		userPasswordValidator.validate(complaint, result);
		if (result.hasErrors()) {
			return "user-login";
		}
		return "complaint-creation";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public String adminLogin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result) {
		return "admin-login";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.POST)
	public String adminAfterLogin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result,
			ModelMap model) {
		adminPasswordValidator.validate(admin, result);
		if(result.hasErrors()) {
			return "admin-login";
		}
		return "complaint-notification-admin";
	}

	@RequestMapping(value = "/analyst-login", method = RequestMethod.GET)
	public String analystLogin(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result) {
		return "analyst-login";
	}

	@RequestMapping(value = "/analyst-login", method = RequestMethod.POST)
	public String analystAfterLogin(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {
		analystPasswordValidator.validate(complaint, result);
		if(result.hasErrors()) {
			return "analyst-login";
		}
		return "complaint-notification-analyst";
	}

}

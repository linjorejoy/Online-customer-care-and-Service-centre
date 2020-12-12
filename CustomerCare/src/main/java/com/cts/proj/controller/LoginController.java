package com.cts.proj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.UserService;
import com.cts.proj.validate.AdminPasswordValidator;
import com.cts.proj.validate.AnalystPasswordValidator;
import com.cts.proj.validate.UserPasswordValidator;

@Controller
public class LoginController {

	@Autowired
	ComplaintService complaintService;

	@Autowired
	AnalystService analystService;
	
	@Autowired
	UserService userService;

	@Autowired
	UserPasswordValidator userPasswordValidator;

	@Autowired
	AnalystPasswordValidator analystPasswordValidator;

	@Autowired
	AdminPasswordValidator adminPasswordValidator;

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public String userLogin(@Validated @ModelAttribute("user") User user, BindingResult result) {

		return "user-login";
	}

	@RequestMapping(value = "/user-login", method = RequestMethod.POST)
	public String userAfterLogin(@Validated @ModelAttribute("user") User user, BindingResult result, ModelMap model) {

		userPasswordValidator.validate(user, result);
		if (result.hasErrors()) {
			return "user-login";
		}
		user = userService.getUser(user.getUserId());
		model.put("user", user);
//		Complaint initializedComplaint = complaintService.getComplaint(1);
//		model.put("initializedComplaint", initializedComplaint);
		return "user-home";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public String adminLogin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result) {
		return "admin-login";
	}

	@RequestMapping(value = "/admin-login", method = RequestMethod.POST)
	public String adminAfterLogin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result,
			ModelMap model) {
		adminPasswordValidator.validate(admin, result);
		if (result.hasErrors()) {
			model.put("analyst", new Analyst());
			model.put("user", new User());
			model.put("adminActive", true);
			model.put("userActive", false);
			model.put("analystActive", false);
			return "role-selection";
		}

		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaint(currentPage - 1, 4, "complaintId", "asc");
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		model.put("currentPage", currentPage);
		model.put("complaintListAdmin", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", "complaintId");
		model.put("sortDir", "asc");
		return "complaint-notification-admin";
	}

	@RequestMapping(value = "/analyst-login", method = RequestMethod.GET)
	public String analystLogin(@Validated @ModelAttribute("analyst") Analyst analyst, BindingResult result) {
		return "analyst-login";
	}

	@RequestMapping(value = "/analyst-login", method = RequestMethod.POST)
	public String analystAfterLogin(@Validated @ModelAttribute("analyst") Analyst analyst, BindingResult result,
			ModelMap model) {
//		System.out.println(complaint);
		analystPasswordValidator.validate(analyst, result);
		if (result.hasErrors()) {
			return "analyst-login";
		}
//		System.out.println(complaint);
		System.out.println(analyst);
		long analystId = analyst.getAnalystId();
		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaintForAnalyst(analyst.getAnalystId(),
				currentPage - 1, 4, "complaintId", "asc");
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

//		System.out.println(complaint);
		Analyst origialAnalyst = analystService.getAnalyst(analystId);
		
		model.put("analyst", origialAnalyst);
		model.put("analystId", analyst.getAnalystId());
		model.put("currentPage", currentPage);
		model.put("complaintListAnalyst", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", "complaintId");
		model.put("sortDir", "asc");
		return "complaint-notification-analyst";
	}
	

	

	@ModelAttribute(name = "categories")
	public Map<String, String> getCategories() {
		Map<String, String> categories = new HashMap<>();
		categories.put("software", "Software");
		categories.put("firmware", "Firmware");
		categories.put("hardware", "Hardware");
		return categories;
	}

}

package com.cts.proj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Admin;
import com.cts.proj.model.Complaint;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
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
	UserPasswordValidator userPasswordValidator;

	@Autowired
	AnalystPasswordValidator analystPasswordValidator;

	@Autowired
	AdminPasswordValidator adminPasswordValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public String userLogin(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result) {
		return "user-login";
	}

	@RequestMapping(value = "/user-login", method = RequestMethod.POST)
	public String userAfterLogin(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {

		userPasswordValidator.validate(complaint, result);
		if (result.hasErrors()) {
			return "user-login";
		}
		Complaint initializedComplaint = complaintService.getComplaint(1);
		model.put("initializedComplaint", initializedComplaint);
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
		if (result.hasErrors()) {
			return "admin-login";
		}
			
		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaint(currentPage - 1, 4, "complaintId", "asc");
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		System.out.println(complaintList);
		model.put("currentPage", currentPage);
		model.put("complaintListAdmin", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", "complaintId");
		model.put("sortDir", "asc");
		
		return "complaint-notification-admin";
	}
	@RequestMapping(value = "/admin-view-filter-category", method = RequestMethod.GET)
	public String adminViewFilter(ModelMap model,String keyword) {
		
	if(keyword !=null) {
		model.addAttribute("complaintListAdmin",complaintService.findByKeyword(keyword));
	}
		return "complaint-notification-admin";
	}
	
	@RequestMapping(value = "/admin-view-filter-date", method = RequestMethod.GET)
	public String adminViewFilterByDate(ModelMap model,String date) {
		
		if(date !=null) {
			model.addAttribute("complaintListAdmin",complaintService.findDate(date));
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
		System.out.println(complaint);
		analystPasswordValidator.validate(complaint, result);
		if (result.hasErrors()) {
			return "analyst-login";
		}
		System.out.println(complaint);
		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaintForAnalyst(complaint.getAnalyst().getAnalystId(),
				currentPage - 1, 4, "complaintId", "asc");
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		System.out.println(complaint);
		
		model.put("analystId", complaint.getAnalyst().getAnalystId());
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

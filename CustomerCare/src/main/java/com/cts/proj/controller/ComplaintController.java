package com.cts.proj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Complaint;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.UserService;
import com.cts.proj.validate.ComplaintValidator;

@Controller
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	UserService userService;

	@Autowired
	ComplaintValidator complaintValidator;

	@RequestMapping(value = "/register-complaint", method = RequestMethod.POST)
	public String registerComplaint(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {

		complaintValidator.validate(complaint, result);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "complaint-creation";
		}
		complaint.setDateOfComplaint(new Date());
		complaintService.addComplaint(complaint);
		model.put("isRegisrered", true);
		model.put("complaintId", complaint.getComplaintId());
		complaint.setUser(userService.getUser(complaint.getUser().getUserId()));
		model.put("submittedComplaint", complaint);
		System.out.println(complaint.getUser());
		return "complaint-submission-user";
	}

//	@RequestMapping(value = "/admin-view-complaint-list", method = RequestMethod.GET)
//	public String viewAllComplaintAdmin(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
//			ModelMap model) {
//		Page<Complaint> pages = complaintService.getAllComplaint();
//		List<Complaint> complaintList = pages.getContent();
//		model.addAttribute("complaintList", complaintList);
//		System.out.println(complaintList);
//		return "complaint-notification-admin";
//	}

	@RequestMapping(value = "/user-view-complaint-list", method = RequestMethod.GET)
	public String viewAllComplaintUser(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {

		List<Complaint> complaintList = complaintService.getAllComplaintOfUser(complaint.getUser().getUserId());
		model.addAttribute("complaintList", complaintList);
		return "complaint-notification-user";
	}

}

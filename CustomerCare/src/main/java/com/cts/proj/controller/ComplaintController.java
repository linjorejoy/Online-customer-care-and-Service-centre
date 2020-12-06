package com.cts.proj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
//	public String viewAllComplaintAdmin(ModelMap model) {
//
//		List<Complaint> complaintList = complaintService.getAllComplaint();
//		model.addAttribute("complaintList", complaintList);
//		return "complaint-notification-admin";
//	}
//
//	@RequestMapping(value = "/user-view-complaint-list", method = RequestMethod.GET)
//	public String viewAllComplaintUser(ModelMap model) {
//
//		List<Complaint> complaintList = complaintService.getAllComplaint();
//		model.addAttribute("complaintList", complaintList);
//		return "complaint-notification-user";
//	}
//
	@RequestMapping(value = "/analyst-view-complaint-list", method = RequestMethod.GET)
	public String viewAllComplaintAnalyst( @ModelAttribute("complaint") Complaint complaint, BindingResult result, ModelMap model) {

		List<Complaint> complaintList = complaintService.getAllComplaintForAnalyst(complaint.getAnalyst().getAnalystId());
		model.addAttribute("complaintListAnalyst", complaintList);
		return "complaint-notification-analyst";
	}

}

package com.cts.proj.controller;

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
import com.cts.proj.validate.ComplaintValidator;

@Controller
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;
	@Autowired
	ComplaintValidator complaintValidator;
	
	@RequestMapping(value = "/register-complaint", method = RequestMethod.POST)
	public String registerComplaint(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {
		
		complaintValidator.validate(complaint, result);
		if (result.hasErrors()) {
			return "complaint-creation";
		}
		complaintService.addComplaint(complaint);
		model.put("isRegisrered", true);
		model.put("complaintId", complaint.getComplaintId());
		return "complaint-submission-user";
	}
	@RequestMapping(value = "/admin-view-complaint-list", method = RequestMethod.GET)
	public String ViewAllComplaintAdmin(ModelMap model) {
		
		List<Complaint> complaintList= complaintService.getAllComplaint();
		model.addAttribute("complaintList",complaintList);
		return "complaint-notification-admin";
	}
	@RequestMapping(value = "/user-view-complaint-list", method = RequestMethod.GET)
	public String ViewAllComplaintUser(ModelMap model) {
		
		List<Complaint> complaintList= complaintService.getAllComplaint();
		model.addAttribute("complaintList",complaintList);
		return "complaint-notification-user";
	}

}

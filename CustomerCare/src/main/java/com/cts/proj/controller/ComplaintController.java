package com.cts.proj.controller;

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

@Controller
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@RequestMapping(value = "/register-complaint", method = RequestMethod.POST)
	public String registerComplaint(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {
		
		if (result.hasErrors()) {
			return "complaint-creation";
		}
		complaintService.addComplaint(complaint);
		model.put("isRegisrered", true);
		model.put("complaintId", complaint.getComplaintId());
		return "complaint-submission-user";
	}

}

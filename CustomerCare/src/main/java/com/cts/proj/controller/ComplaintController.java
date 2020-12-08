package com.cts.proj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.proj.model.Admin;
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

	@RequestMapping(value = "/user-view-complaint-list", method = RequestMethod.GET)
	public String viewAllComplaintUser(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {

		List<Complaint> complaintList = complaintService.getAllComplaintOfUser(complaint.getUser().getUserId());
		model.addAttribute("complaintList", complaintList);
		return "complaint-notification-user";
	}

	@RequestMapping(value = "/admin-login/page/{pageNumber}", method = RequestMethod.GET)
	public String viewAnotherPageAdminComplaintList(@Validated @ModelAttribute("admin") Admin admin,
			BindingResult result, ModelMap model, @PathVariable("pageNumber") int pageNumber,
			@Param("sortBy") String sortBy, @Param("sortDir") String sortDir) {

		Page<Complaint> pages = complaintService.getAllComplaint(pageNumber - 1, 4, sortBy, sortDir);
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		model.put("currentPage", pageNumber);
		model.put("complaintListAdmin", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", sortBy);
		model.put("sortDir", sortDir);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.put("reverseSortDir", reverseSortDir);
		return "complaint-notification-admin";

	}

	@RequestMapping(value = "/analyst-login/page/{pageNumber}", method = RequestMethod.GET)
	public String viewAnotherPageAnalystComplaintList(@Validated @ModelAttribute("complaint") Complaint complaint,
			BindingResult result, ModelMap model, @PathVariable("pageNumber") int pageNumber,
			@Param("analystId") long analystId, @Param("sortBy") String sortBy, @Param("sortDir") String sortDir) {

		System.out.println("Analyst Id is : " + analystId);
		Page<Complaint> pages = complaintService.getAllComplaintForAnalyst(analystId,
				pageNumber - 1, 4, sortBy, sortDir);
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		System.out.println();
		System.out.println();
		System.out.println(complaintList);
		System.out.println();
		System.out.println();
		model.put("analystId", analystId);
		model.put("currentPage", pageNumber);
		model.put("complaintListAnalyst", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", sortBy);
		model.put("sortDir", sortDir);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.put("reverseSortDir", reverseSortDir);
		return "complaint-notification-analyst";

	}

}

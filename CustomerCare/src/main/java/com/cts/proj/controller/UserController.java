package com.cts.proj.controller;

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

import com.cts.proj.model.Complaint;
import com.cts.proj.model.User;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ComplaintService complaintService;

	@RequestMapping(value = "/user-home")
	public String userGoToHome(@RequestParam("userId") long userId, ModelMap model) {

		User user = userService.getUser(userId);
		model.put("emailCount", user.getEmailList().size());
		model.put("userId", userId);
		model.put("user", user);
		return "user-home";
	}

	@RequestMapping(value = "/user-complaint-list-view", method = RequestMethod.GET)
	public String adminAfterLogin(@Validated @ModelAttribute("user") User user, BindingResult result, ModelMap model) {

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
		return "complaint-notification-user";
	}

	@RequestMapping(value = "/user-complaint-list-view/page/{pageNumber}", method = RequestMethod.GET)
	public String viewAnotherPageAdminComplaintList(@Validated @ModelAttribute("user") User user, BindingResult result,
			ModelMap model, @PathVariable("pageNumber") int pageNumber, @Param("sortBy") String sortBy,
			@Param("sortDir") String sortDir, String keyword, String date, String userId, String complaintId) {

		Page<Complaint> pages = complaintService.getAllComplaint(pageNumber - 1, 4, sortBy, sortDir);
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		model.put("complaintListAdmin", complaintList);

		model.put("currentPage", pageNumber);
		if (keyword != null && !keyword.isEmpty()) {
			model.addAttribute("complaintListAdmin", complaintService.findByKeyword(keyword));
		}

		if (date != null && !date.isEmpty()) {
			model.addAttribute("complaintListAdmin", complaintService.findDate(date));
		}
		if (userId != null && !userId.isEmpty()) {
			model.addAttribute("complaintListAdmin", complaintService.findByUserId(userId));
		}
		if (complaintId != null && !complaintId.isEmpty()) {
			model.addAttribute("complaintListAdmin", complaintService.findByComplaintId(complaintId));
		}
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", sortBy);
		model.put("sortDir", sortDir);
		model.put("keyword", keyword);
		model.put("date", date);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.put("reverseSortDir", reverseSortDir);
		return "complaint-notification-user";

	}
}

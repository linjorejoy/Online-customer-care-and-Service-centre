package com.cts.proj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cts.proj.model.Analyst;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.User;
import com.cts.proj.service.AnalystService;
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
	AnalystService analystService;

	@Autowired
	ComplaintValidator complaintValidator;

	@RequestMapping(value = "/create-complaint", method = RequestMethod.GET)
	public String goToComplaintPage(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
			@RequestParam("userId") long userId, ModelMap model) {

		User user = userService.getUser(userId);
		Analyst analyst = analystService.getAnalyst(2001);

		long complaintId = complaintService.getLastId() + 1;
		Complaint baseComplaint = new Complaint(complaintId, "Select Category", 0, "Please Fill The Description",
				"Active", new Date(), "please Fill Suggestios", user, analyst);
//		complaint.setComplaintId(complaintId);
		complaintService.addComplaint(baseComplaint);

		model.put("baseComplaint", baseComplaint);
		System.out.println(baseComplaint);
		model.put("user", userService.getUser(userId));
		return "complaint-creation";
	}

	@RequestMapping(value = "/register-complaint", method = RequestMethod.POST)
	public String registerComplaint(@Validated @ModelAttribute("complaint") Complaint complaint, BindingResult result,
			@RequestParam("userId") long userId, @RequestParam("complaintId") long complaintId, ModelMap model) {

		complaintValidator.validate(complaint, result);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "complaint-creation";
		}
		Complaint baseComplaint = complaintService.getComplaint(complaintId);
		baseComplaint.setPhoneNumber(complaint.getPhoneNumber());
		baseComplaint.setCategory(complaint.getCategory());
		baseComplaint.setDescription(complaint.getDescription());
		User user = userService.getUser(userId);
		System.out.println(complaint);
		complaintService.addComplaint(baseComplaint);

		model.put("submittedComplaint", baseComplaint);
		model.put("user", user);

		return "complaint-submission-user";
	}

	@RequestMapping(value = "/user-view-complaint-list", method = RequestMethod.GET)
	public String viewAllComplaintUser(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
			ModelMap model) {

		List<Complaint> complaintList = complaintService.getAllComplaintOfUser(complaint.getUser().getUserId());
		model.addAttribute("complaintList", complaintList);
		return "complaint-notification-user";
	}

//	@RequestMapping(value = "/admin-login/page/{pageNumber}", method = RequestMethod.GET)
//	public String viewAnotherPageAdminComplaintList(@Validated @ModelAttribute("admin") Admin admin,
//			BindingResult result, ModelMap model, @PathVariable("pageNumber") int pageNumber,
//			@Param("sortBy") String sortBy, @Param("sortDir") String sortDir, String keyword, String date) {
//
//		Page<Complaint> pages = complaintService.getAllComplaint(pageNumber - 1, 4, sortBy, sortDir);
//		List<Complaint> complaintList = pages.getContent();
//		long totalComplaints = pages.getTotalElements();
//		int totalPages = pages.getTotalPages();
//		model.put("complaintListAdmin", complaintList);
//
//		model.put("currentPage", pageNumber);
//		if (keyword != null && !keyword.isEmpty()) {
//			model.addAttribute("complaintListAdmin", complaintService.findByKeyword(keyword));
//		}
//
//		if (date != null && !date.isEmpty()) {
//			model.addAttribute("complaintListAdmin", complaintService.findDate(date));
//		}
//		model.put("totalComplaints", totalComplaints);
//		model.put("totalPages", totalPages);
//		model.put("sortBy", sortBy);
//		model.put("sortDir", sortDir);
//		model.put("keyword", keyword);
//		model.put("date", date);
//		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
//		model.put("reverseSortDir", reverseSortDir);
//		return "complaint-notification-admin";
//
//	}

	/*
	 * 
	 */
	@RequestMapping(value = "/admin-login/page/{pageNumber}", method = RequestMethod.GET)
	public String viewAnotherPageAdminComplaintList(@Validated @ModelAttribute("admin") Admin admin,
			BindingResult result, ModelMap model, @PathVariable("pageNumber") int pageNumber,
			@Param("sortBy") String sortBy, @Param("sortDir") String sortDir, String keyword, String date) {

//		Page<Complaint> pages = complaintService.getAllComplaint(pageNumber - 1, 4, sortBy, sortDir);
//		List<Complaint> complaintList = pages.getContent();
//		long totalComplaints = pages.getTotalElements();
//		int totalPages = pages.getTotalPages();
//		model.put("complaintListAdmin", complaintList);
//
//		model.put("currentPage", pageNumber);
//		if (keyword != null && !keyword.isEmpty()) {
//			model.addAttribute("complaintListAdmin", complaintService.findByKeyword(keyword));
//		}
//
//		if (date != null && !date.isEmpty()) {
//			model.addAttribute("complaintListAdmin", complaintService.findDate(date));
//		}
		model.put("currentPage", pageNumber);
		Page<Complaint> allFilteredPages = complaintService.getAllComplaintKeyword(keyword, date, pageNumber - 1, 4,
				sortBy, sortDir);
		List<Complaint> complaintListNew = allFilteredPages.getContent();
		long totalComplaints = allFilteredPages.getTotalElements();
		int totalPages = allFilteredPages.getTotalPages();
		model.put("complaintListAdmin", complaintListNew);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", sortBy);
		model.put("sortDir", sortDir);
		model.put("keyword", keyword);
		model.put("date", date);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.put("reverseSortDir", reverseSortDir);
		return "complaint-notification-admin";

	}
	/*
	 * 
	 */

	@RequestMapping(value = "/analyst-login/page/{pageNumber}", method = RequestMethod.GET)
	public String viewAnotherPageAnalystComplaintList(@Validated @ModelAttribute("analyst") Analyst analyst,
			BindingResult result, ModelMap model, @PathVariable("pageNumber") int pageNumber,
			@Param("analystId") long analystId, @Param("sortBy") String sortBy, @Param("sortDir") String sortDir) {

		System.out.println("Analyst Id is : " + analystId);
		Page<Complaint> pages = complaintService.getAllComplaintForAnalyst(analystId, pageNumber - 1, 4, sortBy,
				sortDir);
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		System.out.println();
		System.out.println();
		System.out.println(complaintList);
		System.out.println();
		System.out.println();
//		long analystId = analyst.getAnalystId();
		model.put("analystId", analystId);
		model.put("currentPage", pageNumber);
		model.put("complaintListAnalyst", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", sortBy);
		model.put("sortDir", sortDir);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.put("reverseSortDir", reverseSortDir);
		model.put("analyst", analystService.getAnalyst(analystId));
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

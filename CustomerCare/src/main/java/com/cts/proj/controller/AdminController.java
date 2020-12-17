package com.cts.proj.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.proj.exporter.ExcelFileExporter;
import com.cts.proj.model.Admin;
import com.cts.proj.model.Analyst;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.EmailAnalyst;
import com.cts.proj.model.EmailUserAnalyst;
import com.cts.proj.model.Feedback;
import com.cts.proj.service.AdminService;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.EmailAnalystService;
import com.cts.proj.service.EmailUserAnalystService;
import com.cts.proj.service.FeedbackService;
import com.cts.proj.service.UserService;

@Controller
public class AdminController {
	@Autowired
	ComplaintService complaintService;

	@Autowired
	UserService userService;

	@Autowired
	AnalystService analystService;

	@Autowired
	AdminService adminService;

	@Autowired
	EmailAnalystService emailAnalystService;
	
	@Autowired
	EmailUserAnalystService emailUserAnalystService;

	@Autowired
	FeedbackService feedbackService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	private String getName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	@RequestMapping(value = "/admin-home", method = RequestMethod.GET)
	public String goToAdminHome(ModelMap model) {
		long adminId = Long.parseLong(getName(model));
		model.put("admin", adminService.getAdmin(adminId));
		return "admin-home";
	}

	@RequestMapping(value = "/admin-create-feedback", method = RequestMethod.GET)
	public String gotoFeedBackAdmin(@ModelAttribute Feedback feedback, @RequestParam("complaintId") long complaintId,
			ModelMap model) {

		List<Feedback> feedbackList = complaintService.getComplaint(complaintId).getFeedbackList();
		model.put("feedbackList", feedbackList);
		model.put("complaintId", complaintId);
		return "feedback-creation-admin";

	}

	@RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
	public String addFeedBack(@ModelAttribute("feedback") Feedback feedback,
			@RequestParam("complaintId") long complaintId, ModelMap model) {

		feedback.setComplaint(complaintService.getComplaint(complaintId));
		feedbackService.addFeedBack(feedback);
		List<Feedback> feedbackList = complaintService.getComplaint(complaintId).getFeedbackList();
		model.put("feedbackList", feedbackList);
		model.put("complaintId", complaintId);
		return "feedback-creation-admin";
	}

	@RequestMapping(value = "/delete-question", method = RequestMethod.GET)
	public String deleteQuestion(@ModelAttribute("feedback") Feedback feedback,
			@RequestParam("responseId") long responseId, @RequestParam("complaintId") long complaintId,
			ModelMap model) {
		feedbackService.deleteFeedback(responseId);
		List<Feedback> feedbackList = complaintService.getComplaint(complaintId).getFeedbackList();
		model.put("feedbackList", feedbackList);
		model.put("complaintId", complaintId);
		return "feedback-creation-admin";
	}

	
	@RequestMapping(value = "/show-all-feedback-admin", method = RequestMethod.GET)
	public String allFeedbackView(ModelMap model) {
		
		List<Feedback> allFeedBack = feedbackService.getAllFeedbacks();
		System.out.println(allFeedBack);
		Map<Complaint, List<Feedback>> feedbackSorted = new HashMap<Complaint, List<Feedback>>();
		for(Feedback feedback : allFeedBack) {
			
			if(feedbackSorted.containsKey(feedback.getComplaint())) {
				List<Feedback> thisComplaintFeedbacks = feedbackSorted.get(feedback.getComplaint());
				thisComplaintFeedbacks.add(feedback);
				feedbackSorted.put(feedback.getComplaint(), thisComplaintFeedbacks);
			}else {
				List<Feedback> thisComplaintFeedbacks = new ArrayList<Feedback>();
				thisComplaintFeedbacks.add(feedback);
				feedbackSorted.put(feedback.getComplaint(), thisComplaintFeedbacks);
				
			}
		}
		System.out.println(feedbackSorted);
		model.put("feedbacksMap", feedbackSorted);
		return "submitted-feedback-view-admin";
	}
	
	
	@RequestMapping(value = "/show-all-complaint-admin", method = RequestMethod.GET)
	public String adminAfterLogin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result,
			ModelMap model) {

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

	@RequestMapping(value = "/show-user-complaint-admin", method = RequestMethod.GET)
	public String showUserComplaint(@RequestParam long complaintId, ModelMap model) {
		Complaint complaint = complaintService.getComplaint(complaintId);
		List<Analyst> analystList = analystService.getAllAnalyst();
//		List<String> supportLevelWithId = new ArrayList<String>();
		Map<String, String> supportLevelWithId = new HashMap<String, String>();

		for (Analyst analyst : analystList) {
			supportLevelWithId.put(Long.toString(analyst.getAnalystId()),
					analyst.getSupportLevel() + " : " + analyst.getAnalystId());
		}
		model.put("supportLevelWithId", supportLevelWithId);
		model.put("complaint", complaint);

		return "complaint-admin-view";

	}

	@RequestMapping(value = "/update-complaint-admin", method = RequestMethod.POST)
	public String updateComplaintAdmin(@Validated @ModelAttribute("complaint") Complaint complaint,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "complaint-admin-view";
		}
		long adminId = Long.parseLong(getName(model));
		Complaint originalComplaint = complaintService.getComplaint(complaint.getComplaintId());
		originalComplaint.setCategory(complaint.getCategory());
		originalComplaint.setStatus(complaint.getStatus());
		long analystId = complaint.getAnalyst().getAnalystId();
		originalComplaint.setAnalyst(analystService.getAnalyst(analystId));
		long emailId = emailAnalystService.getLastId() + 1;

		complaintService.addComplaint(originalComplaint);

		EmailAnalyst emailToAnalyst = new EmailAnalyst();
		emailToAnalyst.setEmailId(emailId);
		emailToAnalyst.setAnalyst(analystService.getAnalyst(analystId));
		emailToAnalyst.setAdmin(adminService.getAdmin(adminId));
		emailToAnalyst.setSentDate(new Date());
		emailToAnalyst.setReceived(false);
//		System.out.println(emailToAnalyst.getAdmin());

		String[] messageTemplate = mailMessage();
		String mailMessage = messageTemplate[0] + emailToAnalyst.getAnalyst().getFirstName() + "\n\n";
		mailMessage += messageTemplate[1] + originalComplaint.getUser().getFirstName() + messageTemplate[2] + "\n";
		mailMessage += messageTemplate[3] + "\n";
		mailMessage += messageTemplate[4] + "\n" + emailToAnalyst.getAdmin().getFirstName();

		emailToAnalyst.setDescription(mailMessage);

		emailAnalystService.addEmail(emailToAnalyst);

//		System.out.println(emailToAnalyst);
		model.put("complaint", originalComplaint);
		model.put("emailAnalyst", emailToAnalyst);
//		model.put("message", mailMessage);
		return "admin-to-analyst-mail";

	}

	@RequestMapping(value = "/sent-email-to-analyst", method = RequestMethod.POST)
	public String sentEmail(@ModelAttribute("emailAnalyst") EmailAnalyst emailAnalyst, BindingResult results,
			ModelMap model) {
		EmailAnalyst originalEmail = emailAnalystService.getEmailAnalyst(emailAnalyst.getEmailId());
		originalEmail.setDescription(emailAnalyst.getDescription());
		emailAnalystService.addEmail(originalEmail);
		return "admin-home";
	}

	@RequestMapping(value = "/download/complaint.xlsx")
	public void downloadExcelSheet(HttpServletResponse response, @RequestParam("complaintId") long complaintId)
			throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
		Complaint complaint = complaintService.getComplaint(complaintId);
		System.out.println(complaint);
		ByteArrayInputStream stream = ExcelFileExporter.complaintToExcel(complaint);
		IOUtils.copy(stream, response.getOutputStream());
	}

	@RequestMapping(value = "/admin-view-filter-category", method = RequestMethod.GET)
	public String adminViewFilter(ModelMap model, String keyword) {

		if (keyword != null) {
			model.addAttribute("complaintListAdmin", complaintService.findByKeyword(keyword));
		}
		return "complaint-notification-admin";
	}

	@RequestMapping(value = "/admin-view-filter-date", method = RequestMethod.GET)
	public String adminViewFilterByDate(ModelMap model, String date) {

		if (date != null) {
			model.addAttribute("complaintListAdmin", complaintService.findDate(date));
		}
		return "complaint-notification-admin";
	}
	

	@RequestMapping(value = "/show-user-complaint-user", method = RequestMethod.GET)
	public String showUserComplaints(@RequestParam long complaintId, ModelMap model) {
		Complaint complaint = complaintService.getComplaint(complaintId);
		List<Analyst> analystList = analystService.getAllAnalyst();
		Map<String, String> supportLevelWithId = new HashMap<String, String>();
		model.put("complaint", complaint);
		return "complaint-view-user";

	}
	
	@RequestMapping(value = "/update-complaint-user", method = RequestMethod.POST)
	public String updateComplaintUser(@Validated @ModelAttribute("complaint") Complaint complaint,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "complaint-admin-view";
		}
		Complaint originalComplaint = complaintService.getComplaint(complaint.getComplaintId());
		//System.out.println(originalComplaint);
		//originalComplaint.setCategory(complaint.getCategory());
		originalComplaint.setStatus(complaint.getStatus());
		long analystId = originalComplaint.getAnalyst().getAnalystId();

		originalComplaint.setAnalyst(analystService.getAnalyst(analystId));
		long emailId = emailUserAnalystService.getLastId() + 1;

		complaintService.addComplaint(originalComplaint);
		
		EmailUserAnalyst email = new EmailUserAnalyst();
		email.setEmailId(emailId);
		email.setAnalyst(analystService.getAnalyst(analystId));
		email.setUser(userService.getUser(Long.parseLong(getName(model))));
		email.setSentDate(new Date());
		email.setReceived(false);

//		EmailAnalyst emailToAnalyst = new EmailAnalyst();
//		emailToAnalyst.setEmailId(emailId);
//		emailToAnalyst.setAnalyst(analystService.getAnalyst(analystId));
//		emailToAnalyst.setAdmin(adminService.getAdmin(1001));
//		emailToAnalyst.setSentDate(new Date());
//		emailToAnalyst.setReceived(false);
		//System.out.println(emailToAnalyst.getAdmin());

		String[] messageTemplate = mailMessage();
		String mailMessage = messageTemplate[0] + email.getAnalyst().getFirstName() + "\n\n";
		mailMessage += messageTemplate[1] + originalComplaint.getUser().getFirstName() + messageTemplate[2] + "\n";
		mailMessage += messageTemplate[3] + "\n";
		mailMessage += messageTemplate[4] + "\n" + email.getUser().getFirstName();

//		emailToAnalyst.setDescription(mailMessage);
		
		email.setDescription(mailMessage);

//		emailAnalystService.addEmail(emailToAnalyst);
		emailUserAnalystService.addEmail(email);

//		System.out.println(emailToAnalyst);
		model.put("complaint", originalComplaint);
//		model.put("emailAnalyst", emailToAnalyst);
		model.put("email", email);
//		model.put("message", mailMessage);
		return "user-to-analyst-mail";

	}
	
	@RequestMapping(value = "/user-sent-email-to-analyst", method = RequestMethod.POST)
	public String sentEmailUser(@ModelAttribute("email") EmailUserAnalyst email, BindingResult results,
			ModelMap model) {
		System.out.println(email.getEmailId());
		EmailUserAnalyst originalEmail = emailUserAnalystService.getEmail(email.getEmailId());
		originalEmail.setDescription(email.getDescription());
		emailUserAnalystService.addEmail(originalEmail);
//		emailAnalystService.addEmail(originalEmail);
		return "user-home";
	}

	@ModelAttribute(name = "category")
	public Map<String, String> getCategory() {
		Map<String, String> category = new HashMap<>();
		category.put("Software", "Software");
		category.put("Hardware", "Hardware");
		category.put("firmware", "firmware");

		return category;
	}

	@ModelAttribute(name = "supportLevel")
	public Map<String, String> getSupportLevel() {
		Map<String, String> supportLevel = new HashMap<>();
		supportLevel.put("L1", "Level 1");
		supportLevel.put("L2", "Level 2");
		supportLevel.put("L3", "Level 3");
		return supportLevel;
	}

	@ModelAttribute(name = "status")
	public Map<String, String> getStatus() {
		Map<String, String> status = new HashMap<>();
		status.put("open", "open");
		status.put("wip", "wip");
		status.put("closed", "closed");
		status.put("reopen", "reopen");
		return status;
	}

	public String[] mailMessage() {
		String[] messages = new String[5];
		messages[0] = "Dear, ";
		messages[1] = "Please do the needfull to rectify the complaint the user ";
		messages[2] = " is facing";
		messages[3] = "Hope this issue is rectified soon,";
		messages[4] = "Regards,";
		return messages;
	}

}

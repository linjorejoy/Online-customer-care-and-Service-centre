package com.cts.proj.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import com.cts.proj.model.Analyst;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.EmailAnalyst;
import com.cts.proj.model.FeedbackQuestions;
import com.cts.proj.service.AdminService;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.EmailAnalystService;
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/admin-home", method = RequestMethod.GET)
	public String goToAdminHome() {
		
		return "admin-home";
	}
	
	@RequestMapping(value = "/admin-create-feedback", method = RequestMethod.GET)
	public String gotoFeedBackAdmin(@ModelAttribute FeedbackQuestions feedbackQuestions ) {
		return "feedback-creation-admin";
		
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
		emailToAnalyst.setAdmin(adminService.getAdmin(1001));
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

package com.cts.proj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.proj.model.Analyst;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.EmailAnalyst;
import com.cts.proj.service.AdminService;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.EmailAnalystService;
import com.cts.proj.service.UserService;

@Controller
public class AnalystController {
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

	@RequestMapping(value = "/view-complaint-analyst", method = RequestMethod.GET)
	public String viewComplaintAnalyst(@RequestParam long complaintId, ModelMap model) {

		Complaint complaint = complaintService.getComplaint(complaintId);
		model.put("complaint", complaint);
		return "complaint-analyst-view";
	}

	@RequestMapping(value = "/analyst-emails")
	public String viewAnalystEmails(@RequestParam("analystId") long analystId, ModelMap model) {

		model.put("analyst", analystService.getAnalyst(analystId));

		return "emails-analyst";
	}

	@RequestMapping(value = "/show-user-complaint-analyst", method = RequestMethod.GET)
	public String showUserComplaint(@RequestParam long complaintId, ModelMap model) {
		Complaint complaint = complaintService.getComplaint(complaintId);
		List<Analyst> analystList = analystService.getAllAnalystNotOfSupportLevel(
				analystService.getAnalyst(complaint.getAnalyst().getAnalystId()).getSupportLevel());
//		List<String> supportLevelWithId = new ArrayList<String>();
		Map<String, String> supportLevelWithId = new HashMap<String, String>();

		for (Analyst analyst : analystList) {
			supportLevelWithId.put(Long.toString(analyst.getAnalystId()),
					analyst.getSupportLevel() + " : " + analyst.getAnalystId());
		}
		model.put("supportLevelWithId", supportLevelWithId);
		model.put("complaint", complaint);

		return "complaint-analyst-view";
	}

	@RequestMapping(value = "/update-complaint-analyst", method = RequestMethod.POST)
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
		return "analyst-to-analyst-mail";

	}

	@RequestMapping(value = "/sent-email-analyst-to-analyst", method = RequestMethod.POST)
	public String sentEmail(@ModelAttribute("emailAnalyst") EmailAnalyst emailAnalyst, BindingResult results,
			ModelMap model) {
		EmailAnalyst originalEmail = emailAnalystService.getEmailAnalyst(emailAnalyst.getEmailId());
		originalEmail.setDescription(emailAnalyst.getDescription());
		emailAnalystService.addEmail(originalEmail);
		return "analyst-home";
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

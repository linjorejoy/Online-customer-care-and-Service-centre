package com.cts.proj.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.cts.proj.model.Analyst;
import com.cts.proj.model.AnalystSecretQuestion;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.EmailAnalyst;
import com.cts.proj.model.EmailUserAnalyst;
import com.cts.proj.model.LoginDetails;
import com.cts.proj.model.User;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AdminService;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.EmailAnalystService;
import com.cts.proj.service.EmailUserAnalystService;
import com.cts.proj.service.LoginDetailsService;
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
	
	@Autowired
	EmailUserAnalystService emailUserAnalystService;
	
	@Autowired
	LoginDetailsService loginDetailsService;

	private String getName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	@RequestMapping(value = "/analyst-home")
	public String analystGoToHome(ModelMap model) {
		long analystId = Long.parseLong(getName(model));
		Analyst analyst = analystService.getAnalyst(analystId);
		
		model.put("emailCount", analyst.getEmailList().size() + analyst.getEmailUserAnalyst().size());
		model.put("analystId", analystId);
		model.put("analyst", analyst);
//		User user = userService.getUser(userId);
//		model.put("emailCount", user.getEmailList().size());
//		model.put("userId", userId);
		return "analyst-home";
	}

	@RequestMapping(value = "/view-complaint-analyst", method = RequestMethod.GET)
	public String viewComplaintAnalyst(@RequestParam long complaintId, ModelMap model) {

		Complaint complaint = complaintService.getComplaint(complaintId);
		model.put("complaint", complaint);
		return "complaint-analyst-view";
	}

	@RequestMapping(value = "/analyst-emails")
	public String viewAnalystEmails(ModelMap model) {

		long analystId = Long.parseLong(getName(model));
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
		long analystId = Long.parseLong(getName(model));
		EmailAnalyst originalEmail = emailAnalystService.getEmailAnalyst(emailAnalyst.getEmailId());
		originalEmail.setDescription(emailAnalyst.getDescription());
		emailAnalystService.addEmail(originalEmail);
		Analyst analyst = analystService.getAnalyst(analystId);
		model.put("analyst", analyst);
		model.put("emailCount", analyst.getEmailList().size());
		return "analyst-home";
	}

	@RequestMapping(value = "/view-email-analyst", method = RequestMethod.GET)
	public String viewEachEmailAnalyst(@RequestParam("emailId") long emailId, ModelMap model) {
		long analystId = Long.parseLong(getName(model));
		EmailAnalyst email = emailAnalystService.getEmailAnalyst(emailId);

		model.put("email", email);
		model.put("analyst", analystService.getAnalyst(analystId));
		return "each-email-analyst";
	}
	
	@RequestMapping(value = "/mark-email-received", method = RequestMethod.GET)
	public String markEmailAnalystReceived(@RequestParam("emailId")long emailId) {
		EmailAnalyst email = emailAnalystService.getEmailAnalyst(emailId);
		email.setReceived(true);
		emailAnalystService.addEmail(email);		
		return "redirect:/analyst-emails";
	}

	
	@RequestMapping(value = "/mark-email-user-received", method = RequestMethod.GET)
	public String markEmailFromUserAnalystReceived(@RequestParam("emailId")long emailId) {
		EmailUserAnalyst email = emailUserAnalystService.getEmail(emailId);
		email.setReceived(true);
		emailUserAnalystService.addEmail(email);		
		return "redirect:/analyst-emails";
	}

	@RequestMapping(value = "/view-email-analyst-from-user", method = RequestMethod.GET)
	public String viewEachEmailAnalystFromUser(@RequestParam("emailId") long emailId, ModelMap model) {
		long analystId = Long.parseLong(getName(model));
		EmailUserAnalyst email 	= emailUserAnalystService.getEmail(emailId);
//		EmailAnalyst email = emailAnalystService.getEmailAnalyst(emailId);

		model.put("email", email);
//		model.put("analyst", analystService.getAnalyst(analystId));
		return "each-email-analyst-from-user";
	}

	@RequestMapping(value = "/analyst-view-all", method = RequestMethod.GET)
	public String analystAfterLogin(@Validated @ModelAttribute("analyst") Analyst analyst, BindingResult result,
			ModelMap model) {
		long analystId = Long.parseLong(getName(model));
//		System.out.println(complaint);
//		System.out.println(complaint);
		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaintForAnalyst(analystId, currentPage - 1, 4, "complaintId",
				"asc");
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

//		System.out.println(complaint);

		model.put("analystId", analystId);
		model.put("currentPage", currentPage);
		model.put("complaintListAnalyst", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", "complaintId");
		model.put("sortDir", "asc");
		return "complaint-notification-analyst";
	}

	@RequestMapping(value = "/forgot-id", method = RequestMethod.GET)
	public String forgotAnalystId(ModelMap model) {
		return "forgot-analyst-Id";
	}

	@RequestMapping(value = "/forgot-analyst-id-secret-question", method = RequestMethod.GET)
	public String forgotAnalystIdSecretQuestion(ModelMap model, String mail) {
		Analyst analyst = analystService.getAnalystFromMail(mail);
		if (analyst != null) {
			model.addAttribute("analyst", analyst);
			model.put("analystId", analyst.getAnalystId());
			return "forgot-analyst-id-sq-question";
		} else {
			return "forgot-analyst-Id";

		}
	}

	@RequestMapping(value = "/submit-secret-question/{analystId}", method = RequestMethod.GET)
	public String secretQuestions(ModelMap model, @PathVariable long analystId, String ans1, String ans2, String ans3) {
		Analyst analyst = analystService.getAnalyst(analystId);
		List<AnalystSecretQuestion> list = analyst.getSecretQuestionList();
		if (analystService.checkSecurityQuestions(list, ans1, ans2, ans3)) {
			model.put("analystId", analyst.getAnalystId());
			return "display-analyst-id";
		} else
			return "forgot-analyst-id-sq-question";

	}

	@RequestMapping(value = "/forgot-password-analyst", method = RequestMethod.GET)
	public String recoverPassword(ModelMap model, String analystId, String mob, String email) {

		Analyst analyst = analystService.findAnalyst(analystId, mob, email);
		if (analyst == null) {
			return "forgot-password-analyst";
		} else {
			model.addAttribute("analyst", analyst);
			model.put("analystId", analyst.getAnalystId());

			return "password-recovery-analyst";
		}
	}

	@RequestMapping(value = "/reset-password-analyst/{analystId}", method = RequestMethod.GET)
	public String verifySecretQuestion(ModelMap model, @PathVariable long analystId, String ans1, String ans2,
			String ans3) {

		Analyst analyst = analystService.getAnalyst(analystId);
		List<AnalystSecretQuestion> secretQuestionList = analyst.getSecretQuestionList();

		if (analystService.checkAnswer(secretQuestionList, ans1, ans2, ans3)) {
			return "set-new-pwd-analyst";
		} else
			return "password-recovery-analyst";

	}
	@RequestMapping(value = "/change-password-analyst", method = RequestMethod.POST)
	public String changePassword(String newPwd, String confirmPwd, long analystId, ModelMap model) {
		Pattern pattern = Pattern
				.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$");
		Matcher matcher = pattern.matcher(newPwd);

		if (newPwd.equals(confirmPwd) && matcher.matches()) {
			Analyst analyst = analystService.getAnalyst(analystId);
			try {
				analyst.setPassword(SecureWithSHA256.getSHA(newPwd));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			analyst.setTempPassword(confirmPwd);
			analystService.addAnalyst(analyst);
			LoginDetails thisAnalyst = loginDetailsService.getLoginDetailsByRegisteredId(analyst.getAnalystId());
			thisAnalyst.setPassword(newPwd);
			loginDetailsService.addLoginDetails(thisAnalyst);
			return "analyst-home";
		}else {
			return "set-new-pwd-analyst";
		}

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

package com.cts.proj.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.cts.proj.model.Feedback;
import com.cts.proj.model.User;
import com.cts.proj.model.UserSecretQuestion;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.SecretQuestionService;
import com.cts.proj.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ComplaintService complaintService;
	
	@Autowired
	SecretQuestionService secretQuestionService;

	@RequestMapping(value = "/user-home")
	public String userGoToHome(@RequestParam("userId") long userId, ModelMap model) {

		User user = userService.getUser(userId);
		model.put("emailCount", user.getEmailList().size());
		model.put("userId", userId);
		model.put("user", user);
		return "user-home";
	}

	@RequestMapping(value = "/user-complaint-list-personal")
	public String userListThisUsers(@RequestParam("userId") long userId, ModelMap model) {

		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaintForUser(userId, currentPage - 1, 4, "complaintId",
				"asc");
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		model.put("userId", userId);
		model.put("user", userService.getUser(userId));
		model.put("currentPage", currentPage);
		model.put("complaintListUser", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", "complaintId");
		model.put("sortDir", "asc");
		return "complaint-notification-user-personnel";
	}

	@RequestMapping(value = "/user-complaint-list-personal/page/{pageNumber}")
	public String userListThisUsersNextPage(@RequestParam("userId") long userId, ModelMap model,
			@PathVariable("pageNumber") int pageNumber, @Param("sortBy") String sortBy,
			@Param("sortDir") String sortDir, String keyword, String date, String complaintId) {

		int currentPage = 1;
		Page<Complaint> pages = complaintService.getAllComplaintForUser(userId, currentPage - 1, 4, sortBy, sortDir);
		List<Complaint> complaintList = pages.getContent();
		long totalComplaints = pages.getTotalElements();
		int totalPages = pages.getTotalPages();

		model.put("userId", userId);
		model.put("user", userService.getUser(userId));
		model.put("currentPage", currentPage);
		model.put("complaintListUser", complaintList);
		model.put("totalComplaints", totalComplaints);
		model.put("totalPages", totalPages);
		model.put("sortBy", "complaintId");
		model.put("sortDir", sortDir);
		model.put("keyword", keyword);
		model.put("date", date);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.put("reverseSortDir", reverseSortDir);
		return "complaint-notification-user-personnel";
	}

	@RequestMapping(value = "/user-complaint-list-view", method = RequestMethod.GET)
	public String userListAll(@Validated @ModelAttribute("user") User user, BindingResult result, ModelMap model) {

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
	public String viewAnotherPageUserListAll(@Validated @ModelAttribute("user") User user, BindingResult result,
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

	@RequestMapping(value = "/submit-user-feedback", method = RequestMethod.GET)
	public String submitFeedback(@ModelAttribute("complaint") Complaint complaint, @RequestParam("userId") long userId,
			@RequestParam("complaintId") long complaintId, ModelMap model) {

		Complaint originalComplaint = complaintService.getComplaint(complaintId);
		List<Feedback> feedbackList = originalComplaint.getFeedbackList();

		System.out.println(feedbackList);

		model.put("user", userService.getUser(userId));
		model.put("complaintId", originalComplaint.getComplaintId());
		model.put("complaint", originalComplaint);
		model.put("feedbackList", feedbackList);
		model.put("userId", userId);
		return "user-feedback-submission";
	}

	@RequestMapping(value = "/submit-feedback", method = RequestMethod.POST)
	public String afterSubmitFeedBack(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
			@RequestParam("userId") long userId, ModelMap model) {

		System.out.println(complaint.getFeedbackList());

		Complaint originalComplaint = complaintService.getComplaint(complaint.getComplaintId());
		List<Feedback> originalFeedbackList = originalComplaint.getFeedbackList();

		for (int i = 0; i < originalFeedbackList.size(); i++) {
			originalFeedbackList.get(i).setAnswer(complaint.getFeedbackList().get(i).getAnswer());
		}

		originalComplaint.setFeedbackList(originalFeedbackList);
		originalComplaint.setSuggestions(complaint.getSuggestions());
		complaintService.addComplaint(originalComplaint);

//		model.put("userId", userId);
		model.addAttribute("userId", userId);
		return "user-home";
	}

	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public String recoverPassword(ModelMap model, String userId, String mob, String email) {

		User user = userService.findUser(userId, mob, email);
		if (user == null) {
			return "forgot-password-user";
		} else {
			model.addAttribute("user", user);
			model.put("userId", user.getUserId());

			return "password-recovery-user";
		}
	}

	@RequestMapping(value = "/reset-password-user/{userId}", method = RequestMethod.GET)
	public String verifySecretQuestion(ModelMap model, @PathVariable long userId, String ans1, String ans2,
			String ans3) {

		User user = userService.getUser(userId);
		List<UserSecretQuestion> secretQuestionList = user.getSecretQuestionList();

		model.put("userId", userId);
		if (userService.checkAnswer(secretQuestionList, ans1, ans2, ans3)) {
			return "set-new-pwd-user";
		} else
			return "password-recovery-user";

	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public String changePassword(String newPwd, String confirmPwd, long userId, ModelMap model) {
		Pattern pattern = Pattern
				.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$");
		Matcher matcher = pattern.matcher(newPwd);

		if (newPwd.equals(confirmPwd) && matcher.matches()) {
			User user = userService.getUser(userId);
			try {
				user.setPassword(SecureWithSHA256.getSHA(newPwd));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setTempPassword(confirmPwd);
			userService.addUser(user);
			return "user-home";
		}else {
			return "set-new-pwd-user";
		}

	}

}

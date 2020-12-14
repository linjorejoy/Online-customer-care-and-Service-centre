package com.cts.proj.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.proj.model.SecretQuestions;
import com.cts.proj.model.User;
import com.cts.proj.model.UserSecretQuestion;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.SecretQuestionService;
import com.cts.proj.service.UserSecretQuestionService;
import com.cts.proj.service.UserService;

@Controller
public class TestController {

	@Autowired
	UserService userService;
	
	@Autowired
	ComplaintService complaintService;
	
	@Autowired
	AnalystService analystService;
	
	@Autowired
	UserSecretQuestionService userSecretQuestionService;
	
	@Autowired
	SecretQuestionService secretQuestionService;
	
	@RequestMapping(value = "/test-sq-qsn", method = RequestMethod.GET)
	public String testAddSecretQsn() {
		
		User user = userService.getUser(3001);
		System.out.println("\n\n" + user);
		
		SecretQuestions qsn1 = secretQuestionService.getQuestionById(9001);
		SecretQuestions qsn2 = secretQuestionService.getQuestionById(9002);
		SecretQuestions qsn3 = secretQuestionService.getQuestionById(9003);

		System.out.println("\n\n");
		System.out.println(qsn1);
		System.out.println(qsn2);
		System.out.println(qsn3);
		System.out.println("\n\n");
		
		List<UserSecretQuestion> questions = new ArrayList<>();
		
		UserSecretQuestion sq1 = new UserSecretQuestion(7001, "ans1", qsn1);
		sq1.setUser(user);
		UserSecretQuestion sq2 = new UserSecretQuestion(7002, "ans2", qsn2);
		sq2.setUser(user);
		UserSecretQuestion sq3 = new UserSecretQuestion(7003, "ans3", qsn3);
		sq3.setUser(user);
		
		questions.add(sq1);
		questions.add(sq2);
		questions.add(sq3);
		
		System.out.println(sq1);
		System.out.println(sq2);
		System.out.println(sq3);
		
		user.setSecretQuestionList(questions);
		
		
//		userSecretQuestionService.addSecretQUestion(sq1);
//		userSecretQuestionService.addSecretQUestion(sq2);
//		userSecretQuestionService.addSecretQUestion(sq3);
		System.out.println(user);
//		user.setSecretQuestionList(questions);
		System.out.println(user);
		
		userService.addUser(user);
		
		return "index";
	}
	


	@RequestMapping(value = "/testSupportLevel", method = RequestMethod.GET)
	@ResponseBody
	public String testAnalystOfSupportLevel() {

		return analystService.getAnalystOfSupportLevel("L2").toString();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String testJpsUser() {

		return userService.getUser(1).toString();
	}

	@RequestMapping(value = "/testpass", method = RequestMethod.GET)
	@ResponseBody
	public String testJpsUserPassword() {
		try {
			System.out.println(userService.getPasswordSHA(1).equals(SecureWithSHA256.getSHA("Linjo")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userService.getPasswordSHA(1);
	}
	
	@RequestMapping(value = "/testAnalystList", method = RequestMethod.GET)
	@ResponseBody
	public String customJPATest() {
		
		return complaintService.getAllComplaintForAnalyst(1, 1, 3, "complaintId", "asc").toString();
	}

}

package com.cts.proj.controller;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cts.proj.model.Analyst;
import com.cts.proj.model.User;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.UserService;
import com.cts.proj.validate.AnalystValidator;
import com.cts.proj.validate.UserValidator;

@Controller
public class RegistrationController {

	@Autowired
	private AnalystService analystService;
	@Autowired
	private UserService userService;
	@Autowired
	AnalystValidator analystValidator;
	@Autowired
	UserValidator userValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/analyst-registration", method = RequestMethod.GET)
	public String analystRegistration(@ModelAttribute Analyst analyst) {
		return "analyst-reg";
	}

	@RequestMapping(value = "/register-analyst", method = RequestMethod.POST)
	public String registerAnalyst(@Validated @ModelAttribute("analyst") Analyst analyst, BindingResult result,
			ModelMap model) {
		
		analystValidator.validate(analyst, result);
		
		if (result.hasErrors()) {
			return "analyst-reg";
		}
		try {
			analyst.setPassword(SecureWithSHA256.getSHA(analyst.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		analystService.addAnalyst(analyst);
		model.put("isRegisrered", true);
		model.put("analystId", analyst.getAnalystId());
		return "analyst-reg-status";
	}

	@RequestMapping(value = "/user-registration", method = RequestMethod.GET)
	public String userRegistration(@ModelAttribute User user) {
		return "user-reg";
	}

	@RequestMapping(value = "/register-user", method = RequestMethod.POST)
	public String registerUser(@Validated @ModelAttribute User user, BindingResult result, ModelMap model) {
		
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "user-reg";
		}
		try {
			user.setPassword(SecureWithSHA256.getSHA(user.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.addUser(user);
		model.put("isRegisrered", true);
		model.put("userId", user.getUserId());
		return "user-reg-status";
	}

	@ModelAttribute("genderList")
	public List<String> populateGender() {
		List<String> genderList = new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Other");
		return genderList;
	}

	@ModelAttribute("supportLevel")
	public Map<String, String> getCategories(){
		Map<String, String> categories = new HashMap<>();
		categories.put("L1", "Level 1");
		categories.put("L2", "Level 2");
		categories.put("L3", "Level 3");
		return categories;
	}
}

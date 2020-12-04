package com.cts.proj.controller;




import java.util.ArrayList;
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

import com.cts.proj.model.Analyst;
import com.cts.proj.model.User;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.UserService;


@Controller
public class RegistrationController {
	
	@Autowired
	private AnalystService analystService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/analyst-registration", method = RequestMethod.GET)
	public String analystRegistration(@ModelAttribute Analyst analyst) {
		return "analyst-reg";
	}

	@RequestMapping(value="/register-analyst" , method=RequestMethod.POST)
	public String registerAnalyst(@Validated @ModelAttribute Analyst analyst, BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return "analyst-reg";
		}
		
		model.put("isRegisrered",true);
		model.put("analystId", analyst.getAnalystId());
		return "forward:/anayst-login";
	}
	
	
	
	@RequestMapping(value = "/user-registration", method = RequestMethod.GET)
	public String userRegistration(@ModelAttribute User user) {
		return "user-reg";
	}
	@RequestMapping(value="/register-user" , method=RequestMethod.POST)
	public String registerUser(@Validated @ModelAttribute User user, BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return "user-reg";
		}
		
		model.put("isRegisrered",true);
		model.put("analystId", user.getUserId());
		return "forward:/user-login";
	}
	
	@ModelAttribute("genderList")
	public List<String> populateGender(){
		List<String> genderList=new ArrayList<String>();	
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Other");
		return genderList;
	}
	@ModelAttribute("supportLevel")
	public Map<String,String> populateSupportLevel(){
		Map<String,String> supportLevel=new HashMap<String,String>();	
		supportLevel.put("L1","L1");
		supportLevel.put("L2","L2");
		supportLevel.put("L3","L3");
		return supportLevel;
	}
}

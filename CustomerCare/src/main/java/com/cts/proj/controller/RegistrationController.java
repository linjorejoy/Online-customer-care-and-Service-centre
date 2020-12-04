package com.cts.proj.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Analyst;
import com.cts.proj.model.User;


@Controller
public class RegistrationController {

	@RequestMapping(value = "/analystRegistration", method = RequestMethod.GET)
	public String analystRegistration(@ModelAttribute Analyst analyst) {
		return "analyst-reg";
	}

	@RequestMapping(value="/registerAnalyst" , method=RequestMethod.GET)
	public String registerAnalyst(@Validated @ModelAttribute Analyst analyst, BindingResult result) {
		if(result.hasErrors()) {
			return "analyst-reg";
		}
		return "anayst-login";
	}
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String userRegistration(@ModelAttribute User user) {
		return "user-reg";
	}
	@RequestMapping(value="/registerUser" , method=RequestMethod.GET)
	public String registerUser(@Validated @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user-reg";
		}
		return "user-login";
	}
	
	@ModelAttribute("genderList")
	public List<String> populateGender(){
		List<String> genderList=new ArrayList<String>();	
		genderList.add("Male");
		genderList.add("Female");
		return genderList;
	}
	@ModelAttribute("supportLevel")
	public List<String> populateSupportLevel(){
		List<String> supportLevel=new ArrayList<String>();	
		supportLevel.add("L1");
		supportLevel.add("L2");
		supportLevel.add("L3");
		return supportLevel;
	}
}

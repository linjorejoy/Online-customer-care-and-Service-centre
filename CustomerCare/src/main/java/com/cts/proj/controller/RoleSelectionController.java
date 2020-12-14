package com.cts.proj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Admin;
import com.cts.proj.model.Analyst;
import com.cts.proj.model.SecretQuestions;
import com.cts.proj.model.User;
import com.cts.proj.service.SecretQuestionService;

@Controller
public class RoleSelectionController {
	
	@Autowired
	SecretQuestionService secretQuestionService;

	@RequestMapping(value = "/roleSelectionPage", method = RequestMethod.GET)
	public String roleSelectionPage(@ModelAttribute("admin") Admin admin, @ModelAttribute("analyst") Analyst analyst,
			@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		model.put("userActive", true);
		model.put("analystActive", false);
		model.put("adminActive", false);
		List<SecretQuestions> alreadyAdded = new ArrayList<>();
		model.put("secretQuestions", secretQuestionService.getAllExcept(alreadyAdded));
		return "role-selection";
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
	
	
	public List<String> getSecretQuestions(){
		
		
		return null;
	}
}

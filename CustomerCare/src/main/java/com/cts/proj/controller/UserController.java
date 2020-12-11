package com.cts.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	
	@RequestMapping(value = "/user-home")
	public String userGoToHome(@RequestParam("userId") long userId, ModelMap model) {
		model.put("userId", userId);
		return "user-home";
	}
	
	
	
	
	
}

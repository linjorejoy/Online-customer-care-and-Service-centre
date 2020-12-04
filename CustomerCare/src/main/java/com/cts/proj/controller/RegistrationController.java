package com.cts.proj.controller;



import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.proj.model.Analyst;


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
}

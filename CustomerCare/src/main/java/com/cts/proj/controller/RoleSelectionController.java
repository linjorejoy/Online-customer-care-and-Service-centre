package com.cts.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class RoleSelectionController {
	
	@RequestMapping(value="/roleSelectionPage", method=RequestMethod.GET)
	public String roleSelectionPage() {
		return "roleSelection";
	}
}

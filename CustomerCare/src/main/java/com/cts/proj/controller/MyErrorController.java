package com.cts.proj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


public class MyErrorController implements ErrorController {
	
	@RequestMapping(value = "/error")
	public String errorHandler(HttpServletRequest request, ModelMap model) {
		String errorPage = "error-page";
		
		
		
		return errorPage;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}

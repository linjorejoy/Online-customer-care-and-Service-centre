package com.cts.proj.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.UserService;

@Controller
public class TestController {

	@Autowired
	UserService userService;

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

}

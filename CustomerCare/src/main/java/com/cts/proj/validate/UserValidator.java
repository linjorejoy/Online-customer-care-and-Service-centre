package com.cts.proj.validate;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.User;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.UserService;

public class UserValidator implements Validator {
	
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		try {
			if(!SecureWithSHA256.getSHA(user.getTempPassword()).equals("")) {
				errors.rejectValue("tempPassword", "passwordError", "Please Enter Correct Password");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

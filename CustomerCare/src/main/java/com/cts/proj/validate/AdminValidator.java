package com.cts.proj.validate;

import java.security.NoSuchAlgorithmException;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Admin;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AdminService;

public class AdminValidator implements Validator {
	
    AdminService adminService;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		return Admin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) target;
		try {
			if(!SecureWithSHA256.getSHA(admin.getTempPassword()).equals(adminService.getAdminPassword(admin.getAdminId())))
				errors.rejectValue("tempPassword", "passwordError", "Enter the correct Password");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

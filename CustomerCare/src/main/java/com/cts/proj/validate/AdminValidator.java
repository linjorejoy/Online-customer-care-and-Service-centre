package com.cts.proj.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Admin;
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
		//int length = (int) (Math.log10(admin.getAdminId())+1);
		if(!(admin.getAdminId()>=1000 && admin.getAdminId()<=9999))
			errors.rejectValue("adminId", "AdminIdError", "Enter the correct Admin ID");

	}

}

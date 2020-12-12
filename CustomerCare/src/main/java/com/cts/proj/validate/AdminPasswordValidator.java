package com.cts.proj.validate;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Admin;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AdminService;

@Service
public class AdminPasswordValidator implements Validator {

	@Autowired
	AdminService adminService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Admin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Admin admin=(Admin) target;
		
		try {
			if(!SecureWithSHA256.getSHA(admin.getTempPassword()).equals(adminService.getPasswordSHA(admin.getAdminId()))) {
				errors.rejectValue("tempPassword", "passwordError", "Please Enter Correct Password");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			errors.rejectValue("adminId", "IdNotAvailable", "The Specified Id is not present in the Database");
		}

	}

}

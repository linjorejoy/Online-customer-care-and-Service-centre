package com.cts.proj.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Complaint;

public class ComplaintValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Complaint complaint = (Complaint) target;
		
		if(!(complaint.getComplaintUserId() >=1000)) {
			errors.rejectValue("complaintId", "complaintIdError", "Should be a valid id");
		}
		
		
	}

}

package com.cts.proj.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Complaint;
@Service
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
		
		if(!(complaint.getUser().getUserId() >=1000)) {
			errors.rejectValue("complaintId", "complaintIdError", "Should be a valid id");
		}
		if(!Long.valueOf(complaint.getPhoneNumber()).toString().matches("^[1-9]{1}[0-9]{9}$")) {
			errors.rejectValue("phoneNumber", "PhoneNUmberError", "Phone Number Should be 10 digits long");
		}
		if(!complaint.getDescription().matches("^[A-Za-z]{10,}.*$")) {
			errors.rejectValue("description", "descriptionError", "Minimum 10 charecters required");
		}
	}

}

package com.cts.proj.validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Analyst;

@Service
public class AnalystValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Analyst analyst=(Analyst) target;
		
		if(!analyst.getFirstName().matches("^[A-Za-z]{2,}$")) {
			errors.rejectValue("firstName", "firstNameError", "Enter first name in correct format");
		}
		if(!analyst.getLastName().matches("^[A-Za-z]{2,}$")) {
			errors.rejectValue("lastName", "lastNameError", "Enter last name in correct format");
		}
		if(!analyst.getPassword().equals(analyst.getTempPassword())) {
			errors.rejectValue("tempPassword", "PasswordMismatch", "Password and Confirm Password does not match");
		}
//											^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{6,}$
		if (!analyst.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$")) {
			errors.rejectValue("password", "PasswordvalidationError",
					"Password Should contain atleast 1 UpperCase, 1 lowercase, 1 special Char and should be atleast 6 letter long");
		}
		if(!(analyst.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
			errors.rejectValue("emailId", "emaildError","Should be a proper email ID format");
		}
		if(analyst.getDateOfBirth() == null) {
			errors.rejectValue("dateOfBirth", "DateNullError", "Date Cannot be left blank");
		}else {
			LocalDate localDate = analyst.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period period = Period.between(localDate, LocalDate.now());
			if(period.getYears() < 18) {
				errors.rejectValue("dateOfBirth", "AgeError", "User Has to be atleast 18 years of age");
			}
		}
	}

}

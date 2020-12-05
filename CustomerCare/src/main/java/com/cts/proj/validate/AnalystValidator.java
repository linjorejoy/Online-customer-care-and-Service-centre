package com.cts.proj.validate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.Analyst;

public class AnalystValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Analyst analyst=(Analyst) target;
		
		if(!analyst.getFirstName().matches("^[A-Za-z]$")) {
			errors.rejectValue("firstName", "firstNameError", "Enter first name in correct format");
		}
		if(!analyst.getLastName().matches("^[A-Za-z]$")) {
			errors.rejectValue("lastName", "lastNameError", "Enter last name in correct format");
		}
		if (!analyst.getPassword().matches("^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[#$@!%&?])[A-Za-z\\d#$@!%&?]{6,}$")) {
			errors.rejectValue("password", "PasswordvalidationError",
					"Password Should contain atleast 1 UpperCase, 1 lowercase, 1 special Char and should be atleast 6 letter long");
		}
		if(!(analyst.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
			errors.rejectValue("emailId", "emaildError","Should be a proper email ID format");
		}
		Date dateOfBirth =analyst.getDateOfBirth();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = dateOfBirth.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		
		LocalDate today = LocalDate.now(); 
		Period age = Period.between(localDate, today);
		if(age.getYears()<18) {
			errors.rejectValue("dateOfBirth", "ageError","Analyst has to be atleast 18 years of age");
		}
	}

}

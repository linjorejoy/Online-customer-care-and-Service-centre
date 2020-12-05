package com.cts.proj.validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.proj.model.User;
import com.cts.proj.service.UserService;

@Service
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
		if (!user.getFirstName().matches("^[A-Za-z ]+$")) {
			errors.rejectValue("firstName", "NameError", "First name is not in correct format");
		}
		if (!user.getLastName().matches("^[A-Za-z ]+$")) {
			errors.rejectValue("lastName", "NameError", "Last name is not in correct format");
		}
		if (!user.getPassword().equals(user.getTempPassword())) {
			errors.rejectValue("password", "PasswordMismatchError", "Password and Temporary Password Doesnt Match");
			errors.rejectValue("tempPassword", "PasswordMismatchError", "Password and Temporary Password Doesnt Match");
		}
		if (!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$")) {
			errors.rejectValue("password", "PasswordvalidationError",
					"Password Should contain atleast 1 UpperCase, 1 lowercase, 1 special Char and should be atleast 6 letter long");
		}
		if(user.getDateOfBirth() == null) {
			errors.rejectValue("dateOfBirth", "DateNullError", "Date Cannot be left blank");
		}else {
			LocalDate localDate = user.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period period = Period.between(localDate, LocalDate.now());
			if(period.getYears() < 18) {
				errors.rejectValue("dateOfBirth", "AgeError", "User Has to be atleast 18 years of age");
			}
		}
		if(!(user.getEmailId().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
			errors.rejectValue("emailId", "EmailIdError","Should be a proper email ID format");
		}
		if(!Long.valueOf(user.getPhoneNumber()).toString().matches("^[1-9]{1}[0-9]{9}$")) {
			errors.rejectValue("phoneNumber", "PhoneNUmberError", "Phone Number Should be 10 digits long");
		}

	}

}

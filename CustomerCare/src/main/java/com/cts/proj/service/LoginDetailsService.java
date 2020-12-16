package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.LoginDetails;
import com.cts.proj.repository.LoginDetailsRepository;

@Service
public class LoginDetailsService {
	
	@Autowired
	LoginDetailsRepository loginDetailsRepository;
	
	public LoginDetails getLoginDetailsByRegisteredId(long registeredId) {
		List<LoginDetails> loginDetail = loginDetailsRepository.getByRegisteredId(registeredId);
		return loginDetail.get(0);
	}
	
	public boolean addLoginDetails(LoginDetails loginDetails) {
		loginDetailsRepository.save(loginDetails);
		return true;
	}
	
	public boolean modifyLoginDetails(LoginDetails loginDetails) {
		loginDetailsRepository.save(loginDetails);
		return true;
	}

}

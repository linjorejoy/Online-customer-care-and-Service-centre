package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.EmailUserAnalyst;
import com.cts.proj.repository.EmailUserAnalystRepository;

@Service
public class EmailUserAnalystService {
	
	@Autowired
	EmailUserAnalystRepository emailUserAnalystRepository;

	public long getLastId() {
		long lastId = 12000;
		
		List<EmailUserAnalyst> allEmails = emailUserAnalystRepository.findAll();
		System.out.println(allEmails);
		if(allEmails != null) {
			for(EmailUserAnalyst email : allEmails) {
				long emailId = email.getEmailId();
				if(emailId > lastId) {
					lastId = emailId;
				}
			}
		}
		
		return lastId;
	}
	
	public boolean addEmail(EmailUserAnalyst email) {
		emailUserAnalystRepository.save(email);
		return true;
	}
	
	public EmailUserAnalyst getEmail(long emailId) {
		return emailUserAnalystRepository.findById(emailId).orElse(null);
	}
	
	
}

package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Complaint;
import com.cts.proj.model.EmailAnalyst;
import com.cts.proj.repository.EmailAnalystRepository;

@Service
public class EmailAnalystService {

	
	@Autowired
	EmailAnalystRepository emailAnalystRepository;
	
	
	public long getLastId() {
		Sort sort = Sort.by("emailId").descending();
		Pageable pageable = PageRequest.of(0, 1, sort);
		List<EmailAnalyst> allComplaints = emailAnalystRepository.findAll(pageable).getContent();
		if(allComplaints.isEmpty()) {
			return 9000;
		}
		return emailAnalystRepository.findAll(pageable).getContent().get(0).getEmailId();
	}
	
	public boolean addEmail(EmailAnalyst email) {
		emailAnalystRepository.save(email);
		return true;
	}
	
	public EmailAnalyst getEmailAnalyst(long emailId) {
		
		return emailAnalystRepository.findById(emailId).orElse(null);
	}
}

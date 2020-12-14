package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.UserSecretQuestion;
import com.cts.proj.repository.UserSecretQuestionRepository;

@Service
public class UserSecretQuestionService {

	@Autowired
	UserSecretQuestionRepository userSecretQuestionRepository;

	public long getLastId() {
		List<UserSecretQuestion> questionResponses = userSecretQuestionRepository.findAll();
		long lastId = 7000;
		if (questionResponses != null) {
			for (UserSecretQuestion question : questionResponses) {
				if (question.getUserSqId() > lastId) {
					lastId = question.getUserSqId();
				}
			}
		}

		return lastId;
	}
	
	public boolean addSecretQUestion(UserSecretQuestion question) {
		
		userSecretQuestionRepository.save(question);
		
		return true;
	}

}

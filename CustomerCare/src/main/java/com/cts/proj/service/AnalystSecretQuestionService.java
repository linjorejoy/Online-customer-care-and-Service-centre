package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.AnalystSecretQuestion;
import com.cts.proj.repository.AnalystSecretQuestionRepository;

@Service
public class AnalystSecretQuestionService {

	@Autowired
	AnalystSecretQuestionRepository analystSecretQuestionRepository;
	
	public long getLastId() {
		List<AnalystSecretQuestion> questionResponses = analystSecretQuestionRepository.findAll();
		long lastId = 8000;
		if(questionResponses != null) {
			for(AnalystSecretQuestion question : questionResponses) {
				if(question.getAnalystSqId() > lastId) {
					lastId = question.getAnalystSqId();
				}
			}
		}
		
		return lastId;
		
	}
	
	public boolean addSecretQuestion(AnalystSecretQuestion question) {
		
		analystSecretQuestionRepository.save(question);
		
		return true;
	}
}

package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.SecretQuestions;
import com.cts.proj.repository.SecretQuestionRepository;

@Service
public class SecretQuestionService {

	@Autowired
	SecretQuestionRepository secretQuestionRepository;
	
	public List<SecretQuestions> getAllQuestions(){
		
		return secretQuestionRepository.findAll();
	}
	
	public List<SecretQuestions> getAllExcept(List<SecretQuestions> alreadyAdded){
		List<SecretQuestions> remainingQuestions = secretQuestionRepository.findAll();
		remainingQuestions.removeAll(alreadyAdded);
		return remainingQuestions;
	}
	
}

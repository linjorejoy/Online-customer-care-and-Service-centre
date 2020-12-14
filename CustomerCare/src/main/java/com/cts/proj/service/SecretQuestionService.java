package com.cts.proj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
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
	
	public List<String> getAllQuestionDescription(){
		
		List<SecretQuestions> questions = secretQuestionRepository.findAll();
		System.out.println("All Questions" + questions);
		List<String> qsnDescription = new ArrayList<String>();
		for(SecretQuestions question : questions) {
			qsnDescription.add(question.getDescription());
		}
		return qsnDescription;
	}
	
}

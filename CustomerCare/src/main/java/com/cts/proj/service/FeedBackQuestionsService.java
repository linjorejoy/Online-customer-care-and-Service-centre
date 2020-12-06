package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.FeedBackQuestions;
import com.cts.proj.repository.FeedBackQuestionsRepository;

@Service
public class FeedBackQuestionsService {
	
	@Autowired
	FeedBackQuestionsRepository feedBackQuestionsRepository;
	
	public List<FeedBackQuestions> getAllFeedBackQuestions(){
		return feedBackQuestionsRepository.findAll();
	}
	
	public FeedBackQuestions getFeedBackQuestion(long feedbackQuestionId) {
		return feedBackQuestionsRepository.findById(feedbackQuestionId).orElse(null);
	}

}

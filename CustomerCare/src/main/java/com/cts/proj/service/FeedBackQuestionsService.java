package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.FeedbackQuestions;
import com.cts.proj.repository.FeedBackQuestionsRepository;

@Service
public class FeedBackQuestionsService {
	
	@Autowired
	FeedBackQuestionsRepository feedBackQuestionsRepository;
	
	public List<FeedbackQuestions> getAllFeedBackQuestions(){
		return feedBackQuestionsRepository.findAll();
	}
	
	public FeedbackQuestions getFeedBackQuestion(long feedbackQuestionId) {
		return feedBackQuestionsRepository.findById(feedbackQuestionId).orElse(null);
	}
	public boolean addFeedBackQuestions(FeedbackQuestions feedBackQuestions) {
		feedBackQuestionsRepository.save(feedBackQuestions);
		return true;
	}
	public boolean deleteFeedBackQuestion(long feedbackQuestionId) {
		feedBackQuestionsRepository.deleteById(feedbackQuestionId);
		return true;
	}

}

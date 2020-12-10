package com.cts.service;


import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.proj.model.FeedbackQuestions;
import com.cts.proj.repository.FeedBackQuestionsRepository;
import com.cts.proj.service.FeedBackQuestionsService;

@RunWith(MockitoJUnitRunner.class)
public class FeedBackQuestionsServiceTest {

	@Mock
	private FeedBackQuestionsRepository feedBackQuestionsRepository;
	@InjectMocks
	FeedBackQuestionsService feedBackQuestionsService;
	@Mock
	FeedbackQuestions feedbackQuestions;
	
	@Test
	public void testGetFeedBackQuestion() {
		feedBackQuestionsService.getFeedBackQuestion(anyLong());
		 Mockito.verify(feedBackQuestionsRepository,Mockito.times(1)).findById(anyLong());
	}
	@Test
	public void testGetAllFeedBackQuestions() {
		feedBackQuestionsService.getAllFeedBackQuestions();
		 Mockito.verify(feedBackQuestionsRepository,Mockito.times(1)).findAll();
	}
	@Test
	public void testAddFeedBackQuestions() {
		feedBackQuestionsService.addFeedBackQuestions(feedbackQuestions);
		 Mockito.verify(feedBackQuestionsRepository,Mockito.times(1)).save(feedbackQuestions);
	}
	@Test
	public void testDeleteFeedBackQuestion() {
		feedBackQuestionsService.deleteFeedBackQuestion(anyLong());
		 Mockito.verify(feedBackQuestionsRepository,Mockito.times(1)).deleteById(anyLong());
	}
}

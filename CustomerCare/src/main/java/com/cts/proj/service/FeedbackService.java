package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Feedback;
import com.cts.proj.repository.FeedbackRepository;

@Service
public class FeedbackService {
     @Autowired
     FeedbackRepository feedbackRepo;
     
     public boolean addFeedBack(Feedback feedback) {
    	 feedbackRepo.save(feedback);
    	 return true;
     }
     public Feedback getFeedBack(Long responseId) {
    	return feedbackRepo.getOne(responseId);
     }
     public List<Feedback> getAllFeedbacks(){
    	 return feedbackRepo.findAll();
     }
     public boolean updateFeedback(Feedback feedback) {
    	 feedbackRepo.save(feedback);
    	 return true;
     }
     public void deleteFeedback(long responseId) {
    	 feedbackRepo.deleteById(responseId);
     }
     public void deleteFeedback(Feedback feedback) {
    	 feedbackRepo.delete(feedback);
     }
     
}

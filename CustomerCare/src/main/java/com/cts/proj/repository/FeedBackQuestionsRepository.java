package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.FeedbackQuestions;

@Repository
public interface FeedBackQuestionsRepository extends JpaRepository<FeedbackQuestions, Long> {

}

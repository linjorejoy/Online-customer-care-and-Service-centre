package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.FeedBackQuestions;

@Repository
public interface FeedBackQuestionsRepository extends JpaRepository<FeedBackQuestions, Long> {

}

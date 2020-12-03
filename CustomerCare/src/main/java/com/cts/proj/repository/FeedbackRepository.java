package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.proj.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}

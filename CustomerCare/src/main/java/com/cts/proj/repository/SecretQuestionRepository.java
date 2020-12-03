package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.proj.model.SecretQuestions;

public interface SecretQuestionRepository extends JpaRepository<SecretQuestions, Long> {

}

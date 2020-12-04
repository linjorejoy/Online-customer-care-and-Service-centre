package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.SecretQuestions;

@Repository
public interface SecretQuestionRepository extends JpaRepository<SecretQuestions, Long> {

}

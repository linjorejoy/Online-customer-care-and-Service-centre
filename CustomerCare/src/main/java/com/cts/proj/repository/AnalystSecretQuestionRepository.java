package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.AnalystSecretQuestion;

@Repository
public interface AnalystSecretQuestionRepository extends JpaRepository<AnalystSecretQuestion, Long> {

}

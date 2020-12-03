package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.proj.model.UserSecretQuestion;

public interface UserSecretQuestionRepository extends JpaRepository<UserSecretQuestion, Long> {

}

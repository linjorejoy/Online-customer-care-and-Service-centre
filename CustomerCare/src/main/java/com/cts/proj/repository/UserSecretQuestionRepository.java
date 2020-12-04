package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.UserSecretQuestion;

@Repository
public interface UserSecretQuestionRepository extends JpaRepository<UserSecretQuestion, Long> {

}

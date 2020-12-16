package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.EmailUserAnalyst;

@Repository
public interface EmailUserAnalystRepository extends JpaRepository<EmailUserAnalyst, Long>{

}

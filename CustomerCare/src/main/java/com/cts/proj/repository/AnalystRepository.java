package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.proj.model.Analyst;

public interface AnalystRepository extends JpaRepository<Analyst, Long> {

}

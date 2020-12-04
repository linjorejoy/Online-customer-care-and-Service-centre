package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Analyst;

@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Long> {

}

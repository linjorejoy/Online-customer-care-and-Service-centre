package com.cts.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Analyst;

@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Long> {
	
	@Query("select a from Analyst a where support_level = ?1")
	List<Analyst> getAnalystOfSupportLevel(String supportLevel);

}

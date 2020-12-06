package com.cts.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

	@Query("FROM Complaint where assigned_analyst_id = ?1")
	List<Complaint> findComplaintsByAnalyst(long analystId);

}

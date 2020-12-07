package com.cts.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Complaint;

@Repository
public interface ComplaintRepository extends PagingAndSortingRepository<Complaint, Long> {

	@Query("select c FROM Complaint c where assigned_analyst_id = ?1")
	List<Complaint> findComplaintsByAnalyst(long analystId);

	@Query("select c from Complaint c where complaint_user_id = ?1")
	List<Complaint> findComplaintForUser(long userId);

}

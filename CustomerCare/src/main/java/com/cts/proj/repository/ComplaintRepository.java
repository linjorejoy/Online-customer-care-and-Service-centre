package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}

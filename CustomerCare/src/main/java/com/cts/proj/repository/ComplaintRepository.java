package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.proj.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}

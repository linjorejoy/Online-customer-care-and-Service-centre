package com.cts.proj.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.LoginDetails;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Long> {
	
	@Query("select l from LoginDetails l where user_name = ?1")
	Optional<LoginDetails> findByUserName(String userName);
	
	@Query("select l from LoginDetails l where user_name = ?1")
	List<LoginDetails> getByRegisteredId(long registeredId);
}

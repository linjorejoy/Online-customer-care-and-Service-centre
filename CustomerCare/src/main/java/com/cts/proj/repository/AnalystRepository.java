package com.cts.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Analyst;

@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Long> {
	
	@Query("select a from Analyst a where support_level = ?1")
	List<Analyst> getAnalystOfSupportLevel(String supportLevel);

	@Query("select a from Analyst a where support_level <> ?1")
	List<Analyst> getAllAnalystNotOfSupportLevel(String supportLevel);

	@Query("select a from Analyst a where support_level > ?1")
	List<Analyst> getAllAnalystGreaterThanSupportLevel(String supportLevel);

	@Query("select a from Analyst a where support_level < ?1")
	List<Analyst> getAllAnalystLessThanSupportLevel(String supportLevel);
	
	@Query("select a from Analyst a where email_id = ?1")
	Analyst getAnalystFromMailId(String mailId);
	
	@Query(value="select * from analyst a where analyst_id=:analystId and phone_number=:mob and email_id=:email ", nativeQuery=true)
	Analyst findAnalyst(@Param("analystId") String analystId,@Param("mob") String mob,@Param("email") String email);
	
}

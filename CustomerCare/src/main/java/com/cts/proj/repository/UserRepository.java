package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value="select * from user u where user_id=:userId and phone_number=:mob and email_id=:email ", nativeQuery=true)
	User findUser(@Param("userId") String userId,@Param("mob") String mob,@Param("email") String email);
}

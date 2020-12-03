package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.proj.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

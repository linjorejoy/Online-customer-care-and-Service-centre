package com.cts.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.Admin;

@Repository
public interface EmailUserRepository extends JpaRepository<Admin, Long>  {

}

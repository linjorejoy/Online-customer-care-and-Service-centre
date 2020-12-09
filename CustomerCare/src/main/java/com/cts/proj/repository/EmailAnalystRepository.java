package com.cts.proj.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cts.proj.model.EmailAnalyst;

@Repository
public interface EmailAnalystRepository extends PagingAndSortingRepository<EmailAnalyst, Long>  {

}

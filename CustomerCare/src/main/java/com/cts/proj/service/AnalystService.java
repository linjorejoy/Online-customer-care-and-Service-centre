package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Analyst;
import com.cts.proj.repository.AnalystRepository;

@Service
public class AnalystService {
	@Autowired
	AnalystRepository analystRepository;

	public boolean addAnalyst(Analyst analyst) {
		analystRepository.save(analyst);
		return true;
	}

	public Analyst getAnalyst(long analystId) {
		return analystRepository.getOne(analystId);
	}

	public List<Analyst> getAllAnalyst() {
		return analystRepository.findAll();
	}

	public void deleteAnalyst(long analystId) {
		analystRepository.deleteById(analystId);
	}

	public boolean deleteAnalyst(Analyst analyst) {
		analystRepository.delete(analyst);
		return true;
	}

	public Analyst updateAnalyst(Analyst analyst) {
		return analystRepository.save(analyst);
	}

	public String getPasswordSHA(long analystId) {
		return analystRepository.getOne(analystId).getPassword();
	}

}

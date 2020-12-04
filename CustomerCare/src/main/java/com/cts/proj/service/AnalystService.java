package com.cts.proj.service;

<<<<<<< HEAD
=======
import org.springframework.stereotype.Service;
>>>>>>> 3c10f9091d1bfbcce3316d6a674e17b8475aa0d9

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

	public void removeAnalyst(long analystId) {
		analystRepository.deleteById(analystId);

	}

	public boolean removeAnalyst(Analyst analyst) {
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

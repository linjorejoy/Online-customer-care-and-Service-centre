package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Analyst;
import com.cts.proj.model.User;
import com.cts.proj.repository.AnalystRepository;

@Service
public class AnalystService {
	@Autowired
	AnalystRepository analystRepository;
	
	public long getLastId() {
		long lastId = 3000;
		
		for(Analyst analyst : analystRepository.findAll()) {
			if(analyst.getAnalystId() > lastId) {
				lastId = analyst.getAnalystId();
			}
		}
		
		return lastId;
	}

	public boolean addAnalyst(Analyst analyst) {
		analystRepository.save(analyst);
		return true;
	}
	
	public List<Analyst> getAllAnalystNotOfSupportLevel(String supportLevel){
		return analystRepository.getAllAnalystNotOfSupportLevel(supportLevel);
	}

	public List<Analyst> getAnalystOfSupportLevel(String supportLevel){
		return analystRepository.getAnalystOfSupportLevel(supportLevel);
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

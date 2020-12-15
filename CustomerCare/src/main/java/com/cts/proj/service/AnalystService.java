package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Analyst;
import com.cts.proj.model.AnalystSecretQuestion;
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
	
	public Analyst getAnalystFromMail(String mailId) {
		return analystRepository.getAnalystFromMailId(mailId);
	}
	
    public boolean checkSecurityQuestions(List<AnalystSecretQuestion> list ,String ans1 ,String ans2 ,String ans3) {
    	String str1 = list.get(0).getAnswer();
    	String str2 = list.get(1).getAnswer();
    	String str3 = list.get(2).getAnswer();
    	if(str1.equalsIgnoreCase(ans1) && str2.equalsIgnoreCase(ans2) && str3.equalsIgnoreCase(ans3))
    		return true;
    	return false;
    }
    
    public Analyst findAnalyst(String analystId,String mob,String email){
		return analystRepository.findAnalyst(analystId, mob, email);
	}
	public boolean checkAnswer(List<AnalystSecretQuestion> list,String ans1,String ans2,String ans3){
		
		String sq1=list.get(0).getAnswer();
		String sq2=list.get(1).getAnswer();
		String sq3=list.get(2).getAnswer();

		if(sq1.equals(ans1) && sq2.equals(ans2) && sq3.equals(ans3)) {
			return true;
		}
		return false;
	}
     
}

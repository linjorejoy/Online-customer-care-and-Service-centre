package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Complaint;
import com.cts.proj.repository.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	ComplaintRepository complaintRepository;
	
	public boolean addComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		return true;
	}
	
	public Page<Complaint> getAllComplaint(int pageNumber, int count){
		Pageable pageable = PageRequest.of(pageNumber, count);
		return complaintRepository.findAll(pageable);
	}
	
	public Complaint getComplaint(long complaintId) {
		return complaintRepository.findById(complaintId).orElse(null);
	}
	
	public boolean updateComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		return true;
	}
	
	public boolean deleteComplaint(long complaintId) {
		complaintRepository.deleteById(complaintId);;
		return true;
	}
	
	public boolean deleteComplaint(Complaint complaint) {
		complaintRepository.delete(complaint);
		return true;
	}
	
	public List<Complaint> getAllComplaintForAnalyst(long analystId){
		List<Complaint> complaintListAnalyst = complaintRepository.findComplaintsByAnalyst(analystId);
		
		return complaintListAnalyst;
		
	}

	public List<Complaint> getAllComplaintOfUser(long userId) {
		// TODO Auto-generated method stub
		
		return complaintRepository.findComplaintForUser(userId);
	}
}

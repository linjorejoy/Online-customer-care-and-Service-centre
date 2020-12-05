package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Complaint> getAllComplaint(){
		return complaintRepository.findAll();
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
}

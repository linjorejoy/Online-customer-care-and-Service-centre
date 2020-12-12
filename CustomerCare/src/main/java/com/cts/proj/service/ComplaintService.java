package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Complaint;
import com.cts.proj.repository.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	ComplaintRepository complaintRepository;

	public long getLastId() {
		Sort sort = Sort.by("complaintId").descending();
		Pageable pageable = PageRequest.of(0, 1, sort);
		List<Complaint> allComplaints = complaintRepository.findAll(pageable).getContent();
		if (allComplaints.isEmpty()) {
			return 4001;
		}
		return complaintRepository.findAll(pageable).getContent().get(0).getComplaintId();
	}

	public boolean addComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		return true;
	}

//	public Page<Complaint> getAllComplaint(int pageNumber, int count, String sortBy, String sortDir) {
//		Sort sort = null;
//		if (sortDir.equalsIgnoreCase("asc")) {
//			sort = Sort.by(sortBy).ascending();
//		} else if (sortDir.equalsIgnoreCase("desc")) {
//			sort = Sort.by(sortBy).descending();
//		} else {
//			sort = Sort.by(sortBy).ascending();
//		}
//		Pageable pageable = PageRequest.of(pageNumber, count, sort);
//		return complaintRepository.findAll(pageable);
//	}

	public Page<Complaint> getAllComplaint(int pageNumber, int count, String sortBy, String sortDir) {
		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else if (sortDir.equalsIgnoreCase("desc")) {
			sort = Sort.by(sortBy).descending();
		} else {
			sort = Sort.by(sortBy).ascending();
		}
		Pageable pageable = PageRequest.of(pageNumber, count, sort);
		return complaintRepository.findAll(pageable);
	}

	public Page<Complaint> getAllComplaintKeyword(String keyword, String date, int pageNumber, int count, String sortBy,
			String sortDir) {
		if (keyword == null || keyword.isEmpty()) {
			keyword = "%";
		}
		if (date == null || date.isEmpty()) {
			date = "%";
		}else {
			date += "%";
		}
		
		
		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else if (sortDir.equalsIgnoreCase("desc")) {
			sort = Sort.by(sortBy).descending();
		} else {
			sort = Sort.by(sortBy).ascending();
		}
		Pageable pageable = PageRequest.of(pageNumber, count, sort);
		return complaintRepository.findByKeywordPageanation(pageable, keyword, date);
	}

	public Complaint getComplaint(long complaintId) {
		return complaintRepository.findById(complaintId).orElse(null);
	}

	public boolean updateComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		return true;
	}

	public boolean deleteComplaint(long complaintId) {
		complaintRepository.deleteById(complaintId);
		return true;
	}

	public boolean deleteComplaint(Complaint complaint) {
		complaintRepository.delete(complaint);
		return true;
	}

	public Page<Complaint> getAllComplaintForAnalyst(long analystId, int pageNumber, int count, String sortBy,
			String sortDir) {
		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else if (sortDir.equalsIgnoreCase("desc")) {
			sort = Sort.by(sortBy).descending();
		} else {
			sort = Sort.by(sortBy).ascending();
		}
		Pageable pageable = PageRequest.of(pageNumber, count, sort);
		return complaintRepository.findComplaintsByAnalyst(pageable, analystId);

	}

	public List<Complaint> getAllComplaintOfUser(long userId) {
		// TODO Auto-generated method stub

		return complaintRepository.findComplaintForUser(userId);
	}

	public List<Complaint> findByKeyword(String keyword) {
		return complaintRepository.findByKeyword(keyword);
	}

	public List<Complaint> findDate(String date) {
		return complaintRepository.findByDate(date);
	}

	public List<Complaint> findByUserId(String userId) {
		return complaintRepository.findByUserId(userId);
	}

	public List<Complaint> findByComplaintId(String complaintId) {
		return complaintRepository.findComplaintId(complaintId);
	}
}

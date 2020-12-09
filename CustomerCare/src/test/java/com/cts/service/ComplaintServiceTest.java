package com.cts.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import com.cts.proj.model.Complaint;
import com.cts.proj.service.ComplaintService;

public class ComplaintServiceTest {

	ComplaintService complaintService;
	Complaint complaint;
	
	@Test
	public void TestGetComplaintNotNull() {
		complaint=complaintService.getComplaint(4001);
		assertTrue(4001==complaint.getComplaintId());
	}
	
	@Test
	public void TestGetComplaintNull() {
		complaint=complaintService.getComplaint(5001);
		assertNull(complaint);
	}
}

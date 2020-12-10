package com.cts.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Matchers.*;
import com.cts.proj.model.Complaint;
import com.cts.proj.repository.ComplaintRepository;
import com.cts.proj.service.ComplaintService;

@RunWith(MockitoJUnitRunner.class)
public class ComplaintServiceTest {

	
	@Mock
	ComplaintRepository complaintRepository;;
    @InjectMocks
	ComplaintService complaintService;
    
    Complaint complaint;
	@Test
	public void TestGetComplaint() {
		complaintService.getComplaint(4001);
		 Mockito.verify(complaintRepository,Mockito.times(1)).findById(anyLong());
	}
	
	
}

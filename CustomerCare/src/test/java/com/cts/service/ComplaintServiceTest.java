package com.cts.service;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Matchers.*;

import java.text.SimpleDateFormat;

import com.cts.proj.model.Analyst;
import com.cts.proj.model.Complaint;
import com.cts.proj.model.User;
import com.cts.proj.repository.ComplaintRepository;
import com.cts.proj.service.ComplaintService;

@RunWith(MockitoJUnitRunner.class)
public class ComplaintServiceTest {

	
	@Mock
	private ComplaintRepository complaintRepository;;
    @InjectMocks
    private ComplaintService complaintService;
    @Mock
    private Complaint complaint;
    @Mock 
    private User user;
    @Mock 
    private Analyst analyst;
   
   
    
	@Test
	public void testGetComplaint() {
		complaintService.getComplaint(anyInt());
		 Mockito.verify(complaintRepository,Mockito.times(1)).findById(anyLong());
	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateComplaint() {
		complaintService.addComplaint((Complaint)Mockito.anyObject());
		Mockito.verify(complaintRepository, Mockito.times(1)).save((Complaint)Mockito.anyObject());
	}
	
	@Test
	public void testDeleteComplaint() {
		complaintService.deleteComplaint((Complaint)Mockito.anyObject());
		Mockito.verify(complaintRepository, Mockito.times(1)).delete((Complaint)Mockito.anyObject());
	}
	
	@Test
	public void testDeleteComplaintById() {
		complaintService.deleteComplaint(anyLong());
		Mockito.verify(complaintRepository, Mockito.times(1)).deleteById(anyLong());
	}
	
	@Test
	public void testGetAllComplaintOfUser() {
		complaintService.getAllComplaintOfUser(anyLong());
		Mockito.verify(complaintRepository, Mockito.times(1)).findComplaintForUser(anyLong());
	}
	@Test
	public void testFindByKeyword() {
		complaintService.findByKeyword(anyString());
		Mockito.verify(complaintRepository, Mockito.times(1)).findByKeyword(anyString());
	}
	@Test
	public void testFindDate() {
		complaintService.findDate(anyString());
		Mockito.verify(complaintRepository, Mockito.times(1)).findByDate(anyString());
	}
}

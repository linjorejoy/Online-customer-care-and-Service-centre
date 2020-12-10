package com.cts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.proj.controller.AdminController;
import com.cts.proj.controller.AnalystController;
import com.cts.proj.model.Complaint;
import com.cts.proj.service.AdminService;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.EmailAnalystService;
import com.cts.proj.service.UserService;


@WebMvcTest(AnalystController.class)
public class AnalystControllerTest {
     @InjectMocks
     private AnalystController analystController;
     @Autowired
     private MockMvc mockMvc;
     @Mock
     private ComplaintService complaintService;
     @Mock
     private UserService userService;
     @Mock
     private AnalystService analystService;
     @Mock
     private AdminService adminService;
     @Mock 
     private EmailAnalystService emailAnalystService;
     @Before
     public void setUp() {
    	MockitoAnnotations.initMocks(this);
    	this.mockMvc = MockMvcBuilders.standaloneSetup(analystController).build();
     }
     @Test
     public void testViewComplaintAnalyst() throws Exception {
    	 this.mockMvc.perform(get("/view-complaint-analyst").
    			 param("complaintId", "2001")).andExpect(view().name("complaint-analyst-view"));
     }
     @Test
     public void testViewAnalystEmails() throws Exception {
    	 this.mockMvc.perform(get("/analyst-emails").param("analystId", "2000")).andExpect(view().name("emails-analyst"));
     }
     @Test
     public void testShowUserComplaints() throws Exception {
    	 this.mockMvc.perform(get("/show-user-complaint-analyst").param("complaintId", "2002"))
    	 .andExpect(view().name("complaint-analyst-view"));
     }
     @Test
     public void testUpdateComplaintAdmin() throws Exception {
    	 Complaint complaint = complaintService.getComplaint(2001);
    	 this.mockMvc.perform(get("/update-complaint-analyst")).andExpect(model().attribute("complaint", "complaint"))
    	 .andExpect(view().name("analyst-to-analyst-mail"));
     }
}

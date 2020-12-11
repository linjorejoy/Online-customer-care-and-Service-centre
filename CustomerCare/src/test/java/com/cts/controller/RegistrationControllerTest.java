package com.cts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.proj.controller.ComplaintController;
import com.cts.proj.controller.RegistrationController;
import com.cts.proj.model.Analyst;
import com.cts.proj.service.AnalystService;
import static org.mockito.Matchers.*;

@WebMvcTest(ComplaintController.class)
public class RegistrationControllerTest {
	
	@Mock
	AnalystService analystService;
	@InjectMocks
	RegistrationController registrationController;
	@Autowired
	private MockMvc mockMvc;
	@Mock
	Analyst analyst;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
	}
	
	@Test
    public void testAnalystRegistration() throws Exception  {
		
		 this.mockMvc.perform(get("/analyst-registration")).andExpect(view().name("analyst-reg"));
	}
	@Test
    public void testUserRegistration() throws Exception  {
		
		 this.mockMvc.perform(get("/user-registration")).andExpect(view().name("user-reg"));
	}

}

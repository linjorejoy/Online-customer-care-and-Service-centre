package com.cts.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.proj.controller.ComplaintController;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.UserService;
import com.cts.proj.validate.ComplaintValidator;

@WebMvcTest(ComplaintController.class)
public class ComplaintControllerTest {
	
	@InjectMocks
	ComplaintController complaintController;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ComplaintService complaintService;

	@Mock
	private UserService userService;

	@Mock
	private AnalystService analystService;
	
	@Mock
	private ComplaintValidator complaintValidator;

	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(complaintController).build();
	}

	@Test
	public void testGoToComplaintPage() throws Exception {
		this.mockMvc.perform(get("/create-complaint").param("userId", "3001"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("complaint-creation"));
	}

}

package com.cts.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.proj.controller.AdminController;
import com.cts.proj.model.Complaint;
import com.cts.proj.service.AdminService;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;
import com.cts.proj.service.EmailAnalystService;
import com.cts.proj.service.UserService;

//@RunWith(SpringRunner.class)
//@SpringBootTest

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AdminController.class)
public class TestAdminController {

	@InjectMocks
	private AdminController adminController;

	private MockMvc mockMvc;
	@Mock
	private ComplaintService complaintService;
	@Mock
	private UserService userService;
	@Mock
	private AdminService adminService;
	@Mock
	private AnalystService analystService;
	@Mock
	private EmailAnalystService emailAnalystService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
	}

//	@Test
//	public void testGoToAdminHome() throws Exception {
//		this.mockMvc.perform(get("/admin-home")).andExpect(status().is(200)).andReturn();
//	}

	@Test
	public void testShowUserComplaint() throws Exception {
		this.mockMvc.perform(get("/show-user-complaint").param("complaintId", "2002"))
				.andExpect(view().name("complaint-admin-view"));
	}

	@Test
	public void testUpdateComplaintAdmin() throws Exception {
		Complaint complaint = complaintService.getComplaint(anyLong());
		this.mockMvc.perform(post("/update-complaint-admin")).andExpect(model().attribute("complaint", complaint))
				.andExpect(view().name("admin-to-analyst-mail"));
	}

}

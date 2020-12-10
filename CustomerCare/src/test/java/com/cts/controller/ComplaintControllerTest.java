package com.cts.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.proj.controller.ComplaintController;

@SpringBootTest
public class ComplaintControllerTest {

	@Autowired
	ComplaintController complaintController;

	@Autowired
	private MockMvc mockMvc;

//	public void testGoToComplaintPage() {
//		this.mockMvc.perform(get("/create-complaint"))
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(content().string(containsString("complaint-creation")));
//	}

}

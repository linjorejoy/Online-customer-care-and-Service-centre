package com.cts.proj.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.proj.exporter.ExcelFileExporter;
import com.cts.proj.model.Complaint;
import com.cts.proj.service.ComplaintService;

@Controller
public class AdminController {
	@Autowired
	ComplaintService service;
	
	@RequestMapping(value="/show-user-complaint",method=RequestMethod.GET)
	public String showUserComplaint(@RequestParam long complaintId,ModelMap model) {
		Complaint complaint=service.getComplaint(complaintId);
		
		model.put("complaint", complaint);
		return "complaint-admin-view";
		
	}
	@RequestMapping(value="/update-complaint-admin",method=RequestMethod.GET)
	public String updateComplaintAdmin(@Validated @ModelAttribute("complaint") Complaint complaint,BindingResult result) {
		if(result.hasErrors()) {
			return "complaint-admin-view";
		}
		service.addComplaint(complaint);
		return "/";
		
	}
	@RequestMapping(value = "/download/complaint.xlsx")
	public void downloadExcelSheet(HttpServletResponse response , @ModelAttribute("complaint") Complaint complaint) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
		ByteArrayInputStream stream = ExcelFileExporter.complaintToExcel(complaint);
		IOUtils.copy(stream, response.getOutputStream());
	}
	@RequestMapping(value="/feedback-questions-admin",method=RequestMethod.GET)
	public String updateFeedbackQuestions() {
		return "feedback-creation-admin";
	}
	@ModelAttribute(name="category")
	public Map<String,String> getCategory(){
		Map<String,String> category=new HashMap<>();
		category.put("Software", "Software");
		category.put("Hardware", "Hardware");
		category.put("firmware", "firmware");

		return category;
	}
	@ModelAttribute(name="supportLevel")
	public Map<String,String> getSupportLevel(){
		Map<String,String> supportLevel=new HashMap<>();
		supportLevel.put("L1", "Level 1");
		supportLevel.put("L2", "Level 2");
		supportLevel.put("L3", "Level 3");
		return supportLevel;
	}
	@ModelAttribute(name="status")
	public Map<String,String> getStatus(){
		Map<String,String> status=new HashMap<>();
		status.put("open", "open");
		status.put("wip", "wip");
		status.put("closed", "closed");
		status.put("reopen", "reopen");
		return status;
	}
	

}

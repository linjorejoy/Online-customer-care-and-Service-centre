package com.cts.proj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.proj.model.Complaint;
import com.cts.proj.service.AnalystService;
import com.cts.proj.service.ComplaintService;

@Controller
public class AnalystController {
	@Autowired
	ComplaintService complaintService;
	
	@Autowired
	AnalystService analystService;
		
	@RequestMapping(value="/view-complaint-analyst", method=RequestMethod.GET)
	public String viewComplaintAnalyst(@RequestParam long complaintId,ModelMap model){
		
		Complaint complaint = complaintService.getComplaint(complaintId);		
		model.put("complaint", complaint);
		return "complaint-analyst-view";
	}
	
	@RequestMapping(value = "/analyst-emails")
	public String viewAnalystEmails(@RequestParam("analystId") long analystId, ModelMap model) {
		
		model.put("analyst", analystService.getAnalyst(analystId));
		
		
		return "emails-analyst";
	}
	
	@RequestMapping(value="/update-complaint-analyst", method=RequestMethod.POST)
	public String updateComplaintAnalyst(@Validated @ModelAttribute("complaint") Complaint complaint,BindingResult result){
		if(result.hasErrors()) {
			return "complaint-analyst-view";
		}
		complaintService.addComplaint(complaint);
		return "#";
	}

	
	@ModelAttribute(name = "supportLevel")
	public Map<String, String> getSupportLevel(){
		Map<String, String> supportLevel = new HashMap<>();
		supportLevel.put("L1", "Level 1");
		supportLevel.put("L2", "Level 2");
		supportLevel.put("L3", "Level 3");
		return supportLevel;
	}
	@ModelAttribute(name = "status")
	public Map<String, String> getStatus(){
		Map<String, String> status = new HashMap<>();
		status.put("open", "open");
		status.put("wip", "wip");
		status.put("closed", "closed");
		status.put("reopen", "reopen");
		return status;
	}
}

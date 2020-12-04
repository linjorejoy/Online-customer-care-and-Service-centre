package com.cts.proj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.Admin;
import com.cts.proj.repository.AdminRepository;

@Service
public class AdminService {
   @Autowired
   private AdminRepository adminRepo;
   
   public Admin getAdmin(long adminId) {
	   return adminRepo.getOne(adminId);
   }
   public String getAdminPassword(long adminId) {
	   Admin admin =  adminRepo.getOne(adminId);
	   return admin.getPassword();
	   
   }
}

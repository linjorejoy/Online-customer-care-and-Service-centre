package com.cts.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import com.cts.proj.model.Admin;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AdminService;

public class AdminServiceTest {
	AdminService service;
	Admin admin;
    @Before
    public void intializeService() {
    	service = new AdminService();
    	admin = new Admin(1002, "pass@123", "pass@123", "Test", "Name", "test@gmail.com");
    	
    	
    }
    @Test
    public void testGetAdminNotNull() {
    	
    	assertTrue(service.getAdmin(1000)!=null);
    }
    @Test
    public void testGetAdminNull() {
    	admin = service.getAdmin(10000);
    	assertTrue(admin == null);
    }
    @Test
    public void testAdminPassword() {
    	try {
			assertTrue(SecureWithSHA256.getSHA(admin.getPassword()).equals(SecureWithSHA256.getSHA(admin.getTempPassword())));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse(false);
		}
    	
    }
    @Test
    public void testPasswordNotNull() {
    	String password= service.getAdminPassword(1000);
    	assertTrue(password!=null);
    }
    
    
}

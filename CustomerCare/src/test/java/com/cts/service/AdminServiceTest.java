package com.cts.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.proj.model.Admin;
import com.cts.proj.security.SecureWithSHA256;
import com.cts.proj.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	AdminService service;
	@MockBean
	Admin admin;
	
    @Before
    public void intializeService() {
    	service = new AdminService();
    	admin = new Admin();
    	admin.setAdminId(1000);
    	admin.setFirstName("Test");
    	admin.setLastName("Admin");
    	admin.setEmailId("admin@gmail.com");
    	admin.setPassword("Pass@123");
    	admin.setTempPassword("Pass@123");    	
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
    public void testGetAdmin() {
    	assertTrue(service.getAdmin(1000).equals(admin));
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
    @Test
    public void testPasswordSHANotNull() {
    	assertTrue(service.getPasswordSHA(1000)!=null);
    }
    
    
}

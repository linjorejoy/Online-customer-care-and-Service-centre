package com.cts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cts.proj.model.User;
import com.cts.proj.service.UserService;
@DataJpaTest
public class UserServiceTest {
	
	UserService service;
	User user;
    @Before
    public void intializeService() {
    	service = new UserService();
    	String sDate1="31/12/1998";  
        Date date1;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			user = new User(3005l, "firstName", "lastName",9874456532l,"firstName@gmail.com",date1,"Male");
		} catch (ParseException e) {
		}
    	
    }
    @Test
    public void testGetUser() {
    	
    	assertEquals("firstName@gmail.com",service.getUser(3005).getEmailId());
    }
    @Test
    public void testPasswordNotNull() {
    	String password= service.getPasswordSHA(3005);
    	assertTrue(password!=null);
    }
    @Test
    public void testUserPassword() {
    	
    }
    @Test
    public void testDeleteUser() {
    	
    }
    @Test
    public void testAddUser() {
    	
    }
    @Test
    public void testUpdateUser() {
    	
    }

}

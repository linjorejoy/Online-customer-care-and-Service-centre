package com.cts.service;

import static org.junit.Assert.assertEquals;

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
<<<<<<< HEAD
    public void intializeService() {
    	service = new UserService();
    	String sDate1="31/12/1998";  
        Date date1;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			//user = new User(3005l, "firstName", "lastName",9874456532l,"firstName@gmail.com",date1,"Male");
		} catch (ParseException e) {
		}
    	
    }
=======
//    public void intializeService() {
//    	service = new UserService();
//    	String sDate1="31/12/1998";  
//        Date date1;
//		try {
//			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//			user = new User(3005l, "firstName", "lastName",9874456532l,"firstName@gmail.com",date1,"Male");
//		} catch (ParseException e) {
//		}
//    	
//    }
>>>>>>> defe05828b6d7a01d8e8c470f6e8f62acffd5349
    @Test
    public void testGetUser() {
    	
    	assertEquals("firstName@gmail.com",service.getUser(3005).getEmailId());
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

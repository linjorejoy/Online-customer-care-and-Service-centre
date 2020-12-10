package com.cts.service;

import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.proj.model.User;
import com.cts.proj.repository.UserRepository;
import com.cts.proj.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	private UserService service;
	@Mock
	private UserRepository userRepository;
	@Mock
	private User user;
//	@Before
//	public void setUp() throws Exception {
//		user=new User(3004l,"Password@123","Password@123","firstName","lastName",9874545641l,"abc@gmail.com",new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-06"),"Male");
//	}
    @Test
    public void testGetAllUsers() {
    	service.getAllUsers();
    	Mockito.verify(userRepository,Mockito.times(1)).findAll();
    }
    @Test
    public void testGetUser(){
    	service.getUser(anyLong());
    	Mockito.verify(userRepository,Mockito.times(1)).getOne(anyLong());
    }
    
    @Test
    public void testDeleteUserById() {
    	service.deleteUser(anyLong());
    	Mockito.verify(userRepository,Mockito.times(1)).deleteById(anyLong());;
    }
    @Test
    public void testAddUser() {
    	service.addUser((User)Mockito.anyObject());
    	Mockito.verify(userRepository,Mockito.times(1)).save((User)Mockito.anyObject());
    }
    @Test
    public void testUpdateUser() {
    	service.addUser((User) Mockito.anyObject());
    	Mockito.verify(userRepository,Mockito.times(1)).save((User)Mockito.anyObject());
    }

}

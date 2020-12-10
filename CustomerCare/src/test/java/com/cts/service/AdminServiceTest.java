package com.cts.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.cts.proj.model.Admin;
import com.cts.proj.repository.AdminRepository;
import com.cts.proj.service.AdminService;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {
	
	@Mock
	AdminRepository repository;
	@InjectMocks
	AdminService service;
	@Mock
	Admin admin;
	
    @Test
    public void testGetAdmin() {
    	
    	service.getAdmin(Mockito.anyLong());
    	Mockito.verify(repository, Mockito.times(1)).getOne(Mockito.anyLong());
    }
   @Test
   public void testGetAdminPassword() {
	   service.getAdminPassword(Mockito.anyLong());
	   when(service.getAdminPassword(Mockito.anyLong())).thenReturn(Mockito.anyString());
   }
   
    
    
}

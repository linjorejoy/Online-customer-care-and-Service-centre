package com.cts.service;



import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.proj.model.Analyst;
import com.cts.proj.repository.AnalystRepository;
import com.cts.proj.service.AnalystService;
@RunWith(MockitoJUnitRunner.class)
public class AnalystServiceTest {
	  @Mock
	  AnalystRepository analystRepo;
	  @InjectMocks
      AnalystService analystService;
	  @Mock
      Analyst analyst;
   
      @Before
      public void SetUp() {
    	  analyst = new Analyst(2001, "pass@231", "pass@231", "Test", "Name", 987654321,"test@gmail.com", new Date() , "Female" , "L1");
    	 // when(analystService.getPasswordSHA(Mockito.anyLong())).thenReturn("pass@231");
    	  
      }
      @SuppressWarnings("deprecation")
	  @Test
      public void testAddAnalyst() {
    	  analystService.addAnalyst((Analyst)Mockito.anyObject());
    	  Mockito.verify(analystRepo, Mockito.times(1)).save((Analyst)Mockito.anyObject());
    	  
      }
      @Test
      public void testgetAllAnalysNotOfSupportLevel() {
    	  analystService.getAllAnalystNotOfSupportLevel(Mockito.anyString());
    	  Mockito.verify(analystRepo, Mockito.times(1)).getAllAnalystNotOfSupportLevel(Mockito.anyString());
    	  
      }
      @Test
      public void testGetAnalystOfSupportLevel() {
    	  analystService.getAnalystOfSupportLevel(Mockito.anyString());
    	  Mockito.verify(analystRepo, Mockito.times(1)).getAnalystOfSupportLevel(Mockito.anyString());
      }
      @Test
      public void testGetAllAnalyst() {
    	  analystService.getAllAnalyst();
    	  Mockito.verify(analystRepo, Mockito.times(1)).findAll();
      }
      @Test
      public void testGetAnalyst() {
    	  analystService.getAnalyst(Mockito.anyLong());
    	  Mockito.verify(analystRepo, Mockito.times(1)).getOne(Mockito.anyLong());
      }
      @Test
      public void testDeleteAnalystById() {
    	  analystService.deleteAnalyst(Mockito.anyLong());
    	  Mockito.verify(analystRepo, Mockito.times(1)).deleteById(Mockito.anyLong());
      }
      @Test
      public void testDeleteAnalyst() {
    	  analystService.deleteAnalyst((Analyst)Mockito.anyObject());
    	  Mockito.verify(analystRepo, Mockito.times(1)).delete((Analyst)Mockito.anyObject());
      }
      @Test
      public void testUpdateAnalyst() {
    	  analystService.updateAnalyst((Analyst)Mockito.anyObject());
    	  Mockito.verify(analystRepo, Mockito.times(1)).save((Analyst)Mockito.anyObject());
      }
      //@Test
      public void testGetPasswordSHA() {
    	 System.out.println(analyst.toString());
    	 analystService.addAnalyst(analyst);
         when(analystService.getPasswordSHA(Mockito.anyLong())).thenReturn("pass@231");
    	 String password = analystService.getPasswordSHA(2001);
    	 System.out.println(password);
    	 assertTrue(password.equals("pass@231"));    	  
      }
     
}

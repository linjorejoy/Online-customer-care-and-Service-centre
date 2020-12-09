package com.cts.service;



import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cts.proj.model.Analyst;
import com.cts.proj.service.AnalystService;

public class AnalystServiceTest {
      AnalystService analystService;
      Analyst analyst1,analyst2,analyst3;
   
      @Before
      public void intialise() throws ParseException {
    	  analystService = new AnalystService();
    	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	  
			 analyst1 = new Analyst(2002, "pass##23", "pass##23", "Test", "Name", 908978675, "test@gmail.com", format.parse("1998-10-23"), "Female", "L1");
			 analyst2 = new Analyst(2003, "pass@#23", "pass@#23", "Test1", "Def", 988978475, "test1@gmail.com", format.parse("1998-12-31"), "Male", "L2");
			 analyst3 = new Analyst(2004, "pass@234", "pass@234", "Test2", "Efg", 918975675, "test2@gmail.com", format.parse("1998-10-23"), "Female", "L3");
			
      }
      @Test
      public void testAddAnalyst() {
    	  assertTrue(analystService.addAnalyst(analyst1));
    	  assertTrue(analystService.addAnalyst(analyst2));
    	  assertTrue(analystService.addAnalyst(analyst3));
      }
      @Test
      public void testgetAnalysNotNullt() {
    	  Analyst analystTemp = analystService.getAnalyst(2002);
    	  assertTrue(analystTemp!= null);
      }
      @Test
      public void testgetAnalyst() {
    	  Analyst analystTemp = analystService.getAnalyst(2003);
    	  assertTrue(analystTemp.equals(analyst2));
      }
      @Test
      public void testGetAllAnalyst() {
    	  List<Analyst> list = analystService.getAllAnalyst();
    	  assertTrue(list.size() == 3);
      }
}

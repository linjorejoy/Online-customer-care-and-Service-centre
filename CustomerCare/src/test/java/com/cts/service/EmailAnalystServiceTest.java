package com.cts.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.proj.model.EmailAnalyst;
import com.cts.proj.repository.EmailAnalystRepository;
import com.cts.proj.service.EmailAnalystService;

@RunWith(MockitoJUnitRunner.class)
public class EmailAnalystServiceTest {

	@Mock
	private EmailAnalystRepository emailAnalystRepository;

	@Mock
	private EmailAnalyst emailAnalyst;

	@InjectMocks
	private EmailAnalystService emailAnalystService;

	@SuppressWarnings("deprecation")
	@Test
	public void testAddUser() {
		emailAnalystService.addEmail((EmailAnalyst) Mockito.anyObject());
		verify(emailAnalystRepository, times(1)).save((EmailAnalyst) Mockito.anyObject());
	}

	@Test
	public void testFindUser() {
		emailAnalystService.getEmailAnalyst(Mockito.anyLong());
		verify(emailAnalystRepository, times(1)).findById(Mockito.anyLong());
	}

}

package com.cts.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.User;
import com.cts.proj.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUser(long userId) {
		return userRepository.getOne(userId);
	}
}

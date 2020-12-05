package com.cts.proj.service;

import java.util.List;

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

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public boolean deleteUser(User user) {
		userRepository.delete(user);
		return true;
	}

	public boolean deleteUser(long userid) {
		userRepository.deleteById(userid);
		return true;
	}

	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}

	public boolean updateUser(User user) {
		userRepository.save(user);
		return true;
	}

	public String getPasswordSHA(long userId) {
		return userRepository.getOne(userId).getPassword();
	}

}

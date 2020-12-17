package com.cts.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.proj.model.User;
import com.cts.proj.model.UserSecretQuestion;
import com.cts.proj.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public long getLastId() {
		long lastId = 3000;

		for (User user : userRepository.findAll()) {
			if (user.getUserId() > lastId) {
				lastId = user.getUserId();
			}
		}

		return lastId;
	}

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

	public User findUser(String userId, String mob, String email) {
		return userRepository.findUser(userId, mob, email);
	}

	public boolean checkAnswer(List<UserSecretQuestion> list, String ans1, String ans2, String ans3) {

		String sq1 = list.get(0).getAnswer();
		String sq2 = list.get(1).getAnswer();
		String sq3 = list.get(2).getAnswer();
//		String sq1="aa";
//		String sq2="bb";
//		String sq3="cc";
		if (sq1.equals(ans1) && sq2.equals(ans2) && sq3.equals(ans3)) {
			return true;
		}
		System.out.println(sq1 + " : " + ans1 + " : " + sq1.equals(ans1));
		System.out.println(sq2 + " : " + ans2 + " : " + sq2.equals(ans2));
		System.out.println(sq3 + " : " + ans3 + " : " + sq3.equals(ans3));
		return false;
	}

	public User findUserId(String email) {
		return userRepository.findUser(email);
	}

	public boolean validateAnswer(List<UserSecretQuestion> list, String ans1, String ans2, String ans3) {

		String sq1 = list.get(0).getAnswer();
		String sq2 = list.get(1).getAnswer();
		String sq3 = list.get(2).getAnswer();
		if (sq1.trim().equalsIgnoreCase(ans1.trim()) && sq2.trim().equalsIgnoreCase(ans2.trim())
				&& sq3.trim().equalsIgnoreCase(ans3.trim())) {
			return true;
		}
		return false;
	}

}

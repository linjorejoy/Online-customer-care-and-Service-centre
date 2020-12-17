package com.cts.proj.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.proj.model.LoginDetails;
import com.cts.proj.repository.LoginDetailsRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	LoginDetailsRepository loginDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<LoginDetails> logins = loginDetailsRepository.findByUserName(username);

		logins.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

		return logins.map(MyUserDetails::new).get();
	}

}

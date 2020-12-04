package com.cts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cts.proj.model.User;
import com.cts.proj.service.UserService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.cts.proj")
@EnableJpaRepositories(basePackages = {"com.cts.proj.repository"})
@EntityScan("com.cts.proj.model")
public class TrialTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TrialTesting.class);
		UserService userService = new UserService();
		User user = userService.getUser(1);
		System.out.println(user);
	}

}

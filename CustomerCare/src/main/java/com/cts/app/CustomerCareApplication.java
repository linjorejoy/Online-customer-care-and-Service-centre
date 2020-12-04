package com.cts.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.cts.proj")
@EnableJpaRepositories("com.cts.proj.repository")
@EntityScan("com.cts.proj.model")
public class CustomerCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCareApplication.class, args);
	}

}

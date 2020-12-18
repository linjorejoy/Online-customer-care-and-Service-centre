package com.cts.proj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/roleSelectionPage").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/forgot-password").permitAll()
				.antMatchers("/reset-password-user/**").permitAll()
				.antMatchers("/forgot-userID-mail").permitAll()
				.antMatchers("/forgot-userID-secretquestions").permitAll()
				.antMatchers("/show-user-id/{userId}").permitAll()
				.antMatchers("/forgot-id").permitAll()
				.antMatchers("/forgot-analyst-id-secret-question").permitAll()
				.antMatchers("/register-user").permitAll()
				.antMatchers("/register-analyst").permitAll()
				.antMatchers("/submit-secret-question/**").permitAll()
				.antMatchers("/").hasAnyRole("ADMIN","ANALYST","USER")
				.antMatchers("/download/**").hasAnyRole("ADMIN","ANALYST")
				.antMatchers("/user-home").hasRole("USER")
				.antMatchers("/user-home/**").hasRole("USER")
				.antMatchers("/user-login").hasRole("USER")
				.antMatchers("/user-complaint-list-personal").hasRole("USER")
				.antMatchers("/user-complaint-list-personal/**").hasRole("USER")
				.antMatchers("/user-complaint-list-view").hasRole("USER")
				.antMatchers("/user-complaint-list-view/**").hasRole("USER")
				.antMatchers("/close-complaint-user").hasRole("USER")
				.antMatchers("/submit-user-feedback").hasRole("USER")
				.antMatchers("/submit-feedback").hasRole("USER")
				.antMatchers("/create-complaint").hasRole("USER")
				.antMatchers("/user-view-complaint-list").hasRole("USER")
				.antMatchers("/register-complaint").hasRole("USER")
				.antMatchers("/show-user-complaint-user").hasRole("USER")
				.antMatchers("/update-complaint-user").hasRole("USER")
				.antMatchers("/user-sent-email-to-analyst").hasRole("USER")
				.antMatchers("/admin-home").hasRole("ADMIN")
				.antMatchers("/admin-login").hasRole("ADMIN")
				.antMatchers("/admin-login/**").hasRole("ADMIN")
				.antMatchers("/admin-create-feedback").hasRole("ADMIN")
				.antMatchers("/addFeedback").hasRole("ADMIN")
				.antMatchers("/delete-question").hasRole("ADMIN")
				.antMatchers("/show-all-complaint-admin").hasRole("ADMIN")
				.antMatchers("/show-user-complaint-admin").hasRole("ADMIN")
				.antMatchers("/update-complaint-admin").hasRole("ADMIN")
				.antMatchers("/close-complaint-admin").hasRole("ADMIN")
				.antMatchers("/sent-email-to-analyst").hasRole("ADMIN")
				.antMatchers("/admin-view-filter-category").hasRole("ADMIN")
				.antMatchers("/admin-view-filter-date").hasRole("ADMIN")
				.antMatchers("/admin-create-feedback**").hasRole("ADMIN")
				.antMatchers("/show-all-feedback-admin").hasRole("ADMIN")
				.antMatchers("/analyst-home").hasRole("ANALYST")
				.antMatchers("/analyst-login").hasRole("ANALYST")
				.antMatchers("/analyst-login/**").hasRole("ANALYST")
				.antMatchers("/analyst-emails").hasRole("ANALYST")
				.antMatchers("/view-complaint-analyst").hasRole("ANALYST")
				.antMatchers("/show-user-complaint-analyst").hasRole("ANALYST")
				.antMatchers("/update-complaint-analyst").hasRole("ANALYST")
				.antMatchers("/close-complaint-analyst").hasRole("ANALYST")
				.antMatchers("/sent-email-analyst-to-analyst").hasRole("ANALYST")
				.antMatchers("/view-email-analyst").hasRole("ANALYST")
				.antMatchers("/analyst-view-all").hasRole("ANALYST")
				.antMatchers("/mark-email-received").hasRole("ANALYST")
				.antMatchers("/mark-email-user-received").hasRole("ANALYST")
				.antMatchers("analyst").hasRole("ANALYST")
				.antMatchers("analyst").hasRole("ANALYST")
				.and()
				.formLogin()
				.and()
				.logout().invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/roleSelectionPage").permitAll();
	}

	@Bean
	public PasswordEncoder passEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}

}

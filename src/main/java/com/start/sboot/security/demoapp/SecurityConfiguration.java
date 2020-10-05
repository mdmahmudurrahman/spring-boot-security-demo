package com.start.sboot.security.demoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("boot")
		    .password("1111")
		    .roles("USER");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// TODO Auto-generated method stub
		return NoOpPasswordEncoder.getInstance();
	}
}

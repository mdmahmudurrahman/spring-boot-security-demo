package com.start.sboot.security.demoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/resources/**", "/static/**", "/css/**").permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/login")
		    .loginProcessingUrl("/authenticateUser")
		    .permitAll();
	}
	
	
}

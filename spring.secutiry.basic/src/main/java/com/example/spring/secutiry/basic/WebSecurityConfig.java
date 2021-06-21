package com.example.spring.secutiry.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
		user.createUser(User.withDefaultPasswordEncoder().username("loda").password("loda").roles("user").build());

		return user;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "home").permitAll() // cho phep tat ca user truy cap
		.anyRequest().authenticated() // nhung url khac can phai login
		.and()
		.formLogin() // cho phep nguoi dung xac thuc bang form login (su dung form login default cua spring security)
			.defaultSuccessUrl("/hello").permitAll() // trang hien thi khi login thanh cong
		.and().logout().permitAll(); // cho phep logout
	}
}

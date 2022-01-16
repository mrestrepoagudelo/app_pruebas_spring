package com.coop.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.cors(Customizer.withDefaults())
//		.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//		.authorizeRequests()
//		.antMatchers(HttpMethod.POST, "/api/login").permitAll().and()
//		.authorizeRequests().antMatchers("/h2-console/**").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic();
//		http.headers().frameOptions().disable();
//	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}
}

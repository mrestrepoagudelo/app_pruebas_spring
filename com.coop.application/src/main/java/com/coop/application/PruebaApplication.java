package com.coop.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.coop.application.security.JWTAuthorizationFilter;

@SpringBootApplication(scanBasePackages = {"com.coop"})
@EnableJpaRepositories(basePackages = {"com.coop"})
@EntityScan(basePackages = {"com.coop"})
@ComponentScan(basePackages = {"com.coop"})
public class PruebaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
			.cors(Customizer.withDefaults())
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.httpBasic();
		}
		
//		@Override
//	    public void configure(WebSecurity web) throws Exception {
//	        web.ignoring().antMatchers("/**");
//	    }
	}

}

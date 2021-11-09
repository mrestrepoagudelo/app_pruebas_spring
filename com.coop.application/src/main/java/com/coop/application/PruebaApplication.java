package com.coop.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.coop"})
@EnableJpaRepositories(basePackages = {"com.coop"})
@EntityScan(basePackages = {"com.coop"})
@ComponentScan(basePackages = {"com.coop"})
public class PruebaApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
}

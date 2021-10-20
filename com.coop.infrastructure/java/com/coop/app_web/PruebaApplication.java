package com.coop.app_web;

import java.time.Duration;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import coop.app.infra.dto.Area;
//import coop.app.infra.dto.EmpleadoVista;
//import coop.app.infra.dto.Persona;
//import coop.app.infra.dto.Subarea;
//import coop.app.infra.dto.TipoDocumento;
//import coop.app.infra.repo.AreaRepository;
//import coop.app.infra.repo.EmpleadoVistaRepository;
//import coop.app.infra.repo.PersonaRepository;
//import coop.app.infra.repo.SubareaRepository;
//import coop.app.infra.repo.TipoDocumentoRepository;
//import coop.app.web.security.JWTAuthorizationFilter;

@SpringBootApplication(scanBasePackages = {"com.coop"})
//@EnableJpaRepositories(basePackages = {"com.coop"})
//@EntityScan(basePackages = {"com.coop"})
//@ComponentScan(basePackages = {"com.coop"})
public class PruebaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}

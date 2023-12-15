package com.ceiba.biblioteca.general_configuration.beanconfiguration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralBean {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

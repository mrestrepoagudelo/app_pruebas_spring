package com.ceiba.biblioteca.biblioteca.infraestructure.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.biblioteca.biblioteca.domain.port.IBibliotecaRepositoryPort;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaCreateService;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaDeleteByIdService;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaFindAllService;
import com.ceiba.biblioteca.biblioteca.domain.service.BibliotecaFindByIdService;

@Configuration
public class BibliotecaBean {

	@Bean
	public BibliotecaCreateService bibliotecaCreateService(IBibliotecaRepositoryPort bibliotecaRepository) {
		return new BibliotecaCreateService(bibliotecaRepository);
	}

	@Bean
	public BibliotecaFindAllService bibliotecaFindAllService(IBibliotecaRepositoryPort bibliotecaRepository) {
		return new BibliotecaFindAllService(bibliotecaRepository);
	}

	@Bean
	public BibliotecaFindByIdService bibliotecaFindByIdService(IBibliotecaRepositoryPort bibliotecaRepository) {
		return new BibliotecaFindByIdService(bibliotecaRepository);
	}

	@Bean
	public BibliotecaDeleteByIdService bibliotecaService(IBibliotecaRepositoryPort bibliotecaRepository) {
		return new BibliotecaDeleteByIdService(bibliotecaRepository);
	}
}

package com.ceiba.biblioteca.libro.infraestructure.beanconfigurarion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.biblioteca.libro.domain.port.ILibroRepositoryPort;
import com.ceiba.biblioteca.libro.domain.service.LibroCreateService;
import com.ceiba.biblioteca.libro.domain.service.LibroDeleteByIdService;
import com.ceiba.biblioteca.libro.domain.service.LibroFindAllService;
import com.ceiba.biblioteca.libro.domain.service.LibroFindByIdService;

@Configuration
public class LibroBean {

	@Bean
	public LibroCreateService libroCreateService(ILibroRepositoryPort libroRepository) {
		return new LibroCreateService(libroRepository);
	}

	@Bean
	public LibroFindAllService libroFindAllService(ILibroRepositoryPort libroRepository) {
		return new LibroFindAllService(libroRepository);
	}

	@Bean
	public LibroFindByIdService libroFindByIdService(ILibroRepositoryPort libroRepository) {
		return new LibroFindByIdService(libroRepository);
	}

	@Bean
	public LibroDeleteByIdService libroService(ILibroRepositoryPort libroRepository) {
		return new LibroDeleteByIdService(libroRepository);
	}
}

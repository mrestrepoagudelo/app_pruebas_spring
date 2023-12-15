package com.ceiba.biblioteca.prestamo.infraestructure.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoCreateService;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoDeleteByIdService;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoFindAllService;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoFindByIdService;
import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;

@Configuration
public class PrestamoBean {

	@Bean
	public PrestamoCreateService PrestamoCreateService(IPrestamoRepositoryPort prestamoRepository, IUsuarioRepositoryPort usuarioRepository) {
		return new PrestamoCreateService(prestamoRepository,  usuarioRepository);
	}

	@Bean
	public PrestamoFindAllService PrestamoFindAllService(IPrestamoRepositoryPort prestamoRepository) {
		return new PrestamoFindAllService(prestamoRepository);
	}

	@Bean
	public PrestamoFindByIdService PrestamoFindByIdService(IPrestamoRepositoryPort prestamoRepository) {
		return new PrestamoFindByIdService(prestamoRepository);
	}

	@Bean
	public PrestamoDeleteByIdService PrestamoService(IPrestamoRepositoryPort prestamoRepository) {
		return new PrestamoDeleteByIdService(prestamoRepository);
	}
}

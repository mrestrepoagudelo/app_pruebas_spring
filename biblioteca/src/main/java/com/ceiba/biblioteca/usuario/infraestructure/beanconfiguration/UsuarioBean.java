package com.ceiba.biblioteca.usuario.infraestructure.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioCreateService;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioDeleteByIdService;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioFindAllService;
import com.ceiba.biblioteca.usuario.domain.service.UsuarioFindByIdService;

@Configuration
public class UsuarioBean {

	@Bean
	public UsuarioCreateService usuarioCreateService(IUsuarioRepositoryPort usuarioRepository) {
		return new UsuarioCreateService(usuarioRepository);
	}

	@Bean
	public UsuarioFindAllService usuarioFindAllService(IUsuarioRepositoryPort usuarioRepository) {
		return new UsuarioFindAllService(usuarioRepository);
	}

	@Bean
	public UsuarioFindByIdService UsuarioFindByIdService(IUsuarioRepositoryPort usuarioRepository) {
		return new UsuarioFindByIdService(usuarioRepository);
	}

	@Bean
	public UsuarioDeleteByIdService usuarioService(IUsuarioRepositoryPort usuarioRepository) {
		return new UsuarioDeleteByIdService(usuarioRepository);
	}
}

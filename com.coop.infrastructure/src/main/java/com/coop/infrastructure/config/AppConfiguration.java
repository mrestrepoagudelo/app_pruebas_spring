package com.coop.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coop.domain.interfaces.persona.IPersonaRepository;
import com.coop.domain.interfaces.persona.IPersonaService;
import com.coop.domain.interfaces.recursoSeguridad.IRecursoSeguridadRepository;
import com.coop.domain.interfaces.recursoSeguridad.IRecursoSeguridadService;
import com.coop.domain.interfaces.usuario.IUsuarioRepository;
import com.coop.domain.service.PersonaServiceImp;
import com.coop.domain.service.RecursoSeguridadServiceImp;
import com.coop.infrastructure.repository.persona.IPersonaJpaRepository;
import com.coop.infrastructure.repository.persona.PersonaRepositoryImp;
import com.coop.infrastructure.repository.recursoSeguridad.IRecursoSeguridadJpaRepository;
import com.coop.infrastructure.repository.recursoSeguridad.RecursoSeguridadRepositoryImp;
import com.coop.infrastructure.repository.usuario.IUsuarioJpaRepository;
import com.coop.infrastructure.repository.usuario.UsuarioRepositoryImp;
import com.coop.infrastructure.utils.DbUtilImpDomain;
import com.coop.domain.interfaces.dbUtil.IDBUtil;
import com.coop.domain.interfaces.perfil.IPerfilRepository;
import com.coop.domain.interfaces.perfil.IPerfilService;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadRepository;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadService;
import com.coop.domain.service.PerfilRecursoSeguridadServiceImp;
import com.coop.domain.service.PerfilServiceImp;
import com.coop.infrastructure.repository.perfil.IPerfilJpaRepository;
import com.coop.infrastructure.repository.perfil.PerfilRepositoryImp;
import com.coop.infrastructure.repository.perfilRecursoSeguridad.IPerfilRecursoSeguridadJpaRepository;
import com.coop.infrastructure.repository.perfilRecursoSeguridad.PerfilRecursoSeguridadRepositoryImp;

@Configuration
public class AppConfiguration {
	
	@Bean
	public IDBUtil dbUtil(){
		return new DbUtilImpDomain();
	}

	@Bean
	public IPersonaService personaService(IPersonaRepository personaRepository) {
		return new PersonaServiceImp(personaRepository);
	}

	@Bean
	public IPersonaRepository personaRepository(IPersonaJpaRepository personaJpaRepository) {
		return new PersonaRepositoryImp(personaJpaRepository);
	}
	
	@Bean
	public IUsuarioRepository usuarioRepository(IUsuarioJpaRepository usuarioJpaRepository) {
		return new UsuarioRepositoryImp(usuarioJpaRepository);
	}
	
	@Bean
	public IPerfilService perfilService(IPerfilRepository perfilRepository) {
		return new PerfilServiceImp(perfilRepository);
	}

	@Bean
	public IPerfilRepository perfilRepository(IPerfilJpaRepository perfilJpaRepository) {
		return new PerfilRepositoryImp(perfilJpaRepository);
	}
	
	@Bean
	public IPerfilRecursoSeguridadService perfilRecursoSeguridadService(IPerfilRecursoSeguridadRepository perfilRecursoSeguridadRepository) {
		return new PerfilRecursoSeguridadServiceImp(perfilRecursoSeguridadRepository);
	}

	@Bean
	public IPerfilRecursoSeguridadRepository perfilRecursoSeguridadRepository(IPerfilRecursoSeguridadJpaRepository perfilRecursoSeguridadJpaRepository) {
		return new PerfilRecursoSeguridadRepositoryImp(perfilRecursoSeguridadJpaRepository);
	}
	
	@Bean
	public IRecursoSeguridadService recursoSeguridadService(IRecursoSeguridadRepository recursoSeguridadRepository) {
		return new RecursoSeguridadServiceImp(recursoSeguridadRepository);
	}

	@Bean
	public IRecursoSeguridadRepository recursoSeguridadRepository(IRecursoSeguridadJpaRepository recursoSeguridadJpaRepository) {
		return new RecursoSeguridadRepositoryImp(recursoSeguridadJpaRepository);
	}
}

package com.ceiba.biblioteca.usuario.infraestructure.adapter.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ceiba.biblioteca.usuario.domain.model.dto.UsuarioDtoRes;
import com.ceiba.biblioteca.usuario.infraestructure.adapter.entity.UsuarioEntity;

@Repository
public interface IUsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
	Optional<UsuarioEntity> findByNumeroIdentificacion(String numeroIdentificaqcion);
	
	@Query(nativeQuery = true, value = "SELECT new UsuarioDtoRes(u.nombres, tu.descripcion) "
			+ "FROM usuario u "
			+ "INNER JOIN tipo_usuario tu "
			+ "on u.id_usuario = tu.id_tipo_usuario "
			+ "WHERE u.id_usuario = ?1")
	Optional<UsuarioDtoRes> getUsuarioById(Long idUsuario);

}

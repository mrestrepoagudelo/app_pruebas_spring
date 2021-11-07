package com.coop.infrastructure.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coop.infrastructure.entities.UsuarioEntity;

@Repository
public interface IUsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long>{
	public UsuarioEntity findByUserName(String login); 
	
	@Query(value = "SELECT * FROM USUARIO WHERE USER_NAME = :USER_NAME AND CLAVE = :CLAVE",nativeQuery = true)
	public UsuarioEntity findByUserNameAndClave(@Param("USER_NAME") String userName, @Param("CLAVE") String clave);
}

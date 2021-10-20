package com.coop.infrastructure.repository.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coop.infrastructure.entities.PersonaEntity;

public interface IPersonaJpaRepository extends JpaRepository<PersonaEntity, Long>{
	
//	@Query(value = "SELECT "
//			+ "P.ID_PERSONA,"
//			+ "P.NOMBRES,"
//			+ "P.PRIMER_APELLIDO,"
//			+ "P.SEGUNDO_APELLIDO,"
//			+ "P.NUMERO_IDENTIFICACION,"
//			+ "P.EMAIL,"
//			+ "P.ID_TIPO_IDENTIFICACION,"
//			+ "T.DESCRIPCION"
//			+ " FROM PERSONA_TEST AS P LEFT JOIN TIPO_IDENTIFICACION AS T ON P.ID_TIPO_IDENTIFICACION = T.ID_TIPO_IDENTIFICACION",
//			countQuery = "SELECT count(1) FROM PERSONA_TEST",
//			nativeQuery = true)
//	public Page<Map<String,String>> findAllQuery(Pageable pageable);
//	
//	@Query(value = "SELECT "
//			+ "P.ID_PERSONA,"
//			+ "P.NOMBRES,"
//			+ "P.PRIMER_APELLIDO,"
//			+ "P.SEGUNDO_APELLIDO,"
//			+ "P.NUMERO_IDENTIFICACION,"
//			+ "P.EMAIL,"
//			+ "P.ID_TIPO_IDENTIFICACION,"
//			+ "T.DESCRIPCION "
//			+ "FROM PERSONA_TEST AS P LEFT JOIN TIPO_IDENTIFICACION AS T ON P.ID_TIPO_IDENTIFICACION = T.ID_TIPO_IDENTIFICACION "
//			+ "WHERE P.ID_TIPO_IDENTIFICACION = :ID_TIPO_IDENTIFICACION",
//			countQuery = "SELECT count(1) FROM PERSONA_TEST",
//			nativeQuery = true)
//	public Page<Map<String,String>> findAllFiltersQuery(
//			@Param("NOMBRES") Integer nombres, 
//			@Param("PRIMER_APELLIDO") Integer primerApellido, 
//			@Param("SEGUNDO_APELLIDO") Integer segudoApellido, 
//			@Param("NUMERO_IDENTIFICACION") Integer numeroIdentificacion, 
//			@Param("EMAIL") Integer email, 
//			@Param("ID_TIPO_IDENTIFICACION") String idTipoIdentificacion,
//			Pageable pageable);
}

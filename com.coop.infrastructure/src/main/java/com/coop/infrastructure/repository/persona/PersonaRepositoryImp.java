package com.coop.infrastructure.repository.persona;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.dto.Persona;
import com.coop.domain.interfaces.persona.IPersonaRepository;
import com.coop.infrastructure.entity.PersonaEntity;
import com.coop.infrastructure.utils.DBUtil;
import com.coop.infrastructure.utils.SQL;

import org.springframework.beans.BeanUtils;

public class PersonaRepositoryImp implements IPersonaRepository{
	
	@Autowired
	private DBUtil dbUtil;
	
	IPersonaJpaRepository personaJpaRepository;
	
	@Autowired
	public PersonaRepositoryImp(IPersonaJpaRepository personaJpaRepository) {
		this.personaJpaRepository = personaJpaRepository;
	}
	
	@Override
	public Persona findById(Long id) {
		PersonaEntity oPersonaEntity = personaJpaRepository.findById(id).orElse(null);
		Persona oPersona = null;
		if(oPersonaEntity != null) {
			oPersona = new Persona();
			BeanUtils.copyProperties(oPersonaEntity, oPersona);
		}
		return oPersona;
	}

	@Override
	public Persona create(Persona oPersona) {
		PersonaEntity oPersonEntity = new PersonaEntity();
        BeanUtils.copyProperties(oPersona, oPersonEntity);
        
        PersonaEntity oPersonaCreated = personaJpaRepository.save(oPersonEntity);
        oPersona.setIdPersona(oPersonaCreated.getIdPersona());
        
		return oPersona;
	}

	@Override
	public void delete(Long id) {
		personaJpaRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		Map<String,Object> mapResponse = new HashMap<>();
		
		SQL oSql = new SQL();
		oSql.select("P.ID_PERSONA");
		oSql.select("P.NOMBRES");
		oSql.select("P.PRIMER_APELLIDO");
		oSql.select("P.SEGUNDO_APELLIDO");
		oSql.select("P.NUMERO_IDENTIFICACION");
		oSql.select("P.ID_TIPO_IDENTIFICACION");
		oSql.select("P.EMAIL");
		oSql.select("T.DESCRIPCION");

		oSql.from("PERSONA P");
		oSql.from("LEFT JOIN TIPO_IDENTIFICACION T ON P.ID_TIPO_IDENTIFICACION = T.ID_TIPO_IDENTIFICACION");
		oSql.from("ORDER BY P.ID_PERSONA ASC");
		
		mapResponse = dbUtil.findAll(oSql, pageNumber, pageSize);
		
		return mapResponse;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParameters, int pageNumber, int pageSize){ 
		Map<String,Object> mapResponse = new HashMap<>();
		SQL oSql = new SQL();
		oSql.select("P.ID_PERSONA");
		oSql.select("P.NOMBRES");
		oSql.select("P.PRIMER_APELLIDO");
		oSql.select("P.SEGUNDO_APELLIDO");
		oSql.select("P.NUMERO_IDENTIFICACION");
		oSql.select("P.ID_TIPO_IDENTIFICACION");
		oSql.select("P.EMAIL");
		oSql.select("T.DESCRIPCION");

		oSql.from("PERSONA P");
		oSql.from("LEFT JOIN TIPO_IDENTIFICACION T ON P.ID_TIPO_IDENTIFICACION = T.ID_TIPO_IDENTIFICACION");
		
		oSql.where("P.NOMBRES LIKE ?", mapParameters.get("nombres"), String.class);
		oSql.where("P.PRIMER_APELLIDO LIKE ?", mapParameters.get("primerApellido"), String.class);
		oSql.where("P.SEGUNDO_APELLIDO LIKE ?", mapParameters.get("segundoApellido"), String.class);
		oSql.where("P.NUMERO_IDENTIFICACION = ?", mapParameters.get("numeroIdentificacion"), Integer.class);
		oSql.where("P.ID_TIPO_IDENTIFICACION = ?", mapParameters.get("idTipoIdentificacion"), Long.class);
		oSql.where("P.EMAIL LIKE ?", mapParameters.get("email"), String.class);
		mapResponse = dbUtil.findAll(oSql, oSql.getParametros(), pageNumber, pageSize);
		return mapResponse;
	}
}

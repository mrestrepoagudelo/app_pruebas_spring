package com.coop.infrastructure.repository.perfilRecursoSeguridad;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.dto.PerfilRecursoSeguridad;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadRepository;
import com.coop.infrastructure.entity.PerfilRecursoSeguridadEntity;
import com.coop.infrastructure.utils.DBUtil;
import com.coop.infrastructure.utils.SQL;

import org.springframework.beans.BeanUtils;

public class PerfilRecursoSeguridadRepositoryImp implements IPerfilRecursoSeguridadRepository{
	
	@Autowired
	private DBUtil dbUtil;
	
	IPerfilRecursoSeguridadJpaRepository perfilRecursoSeguridadJpaRepository;
	
	@Autowired
	public PerfilRecursoSeguridadRepositoryImp(IPerfilRecursoSeguridadJpaRepository perfilRecursoSeguridadJpaRepository) {
		this.perfilRecursoSeguridadJpaRepository = perfilRecursoSeguridadJpaRepository;
	}
	
	@Override
	public PerfilRecursoSeguridad findById(Long id) {
		PerfilRecursoSeguridadEntity oPerfilRecursoSeguridadEntity = perfilRecursoSeguridadJpaRepository.findById(id).orElse(null);
		PerfilRecursoSeguridad oPerfilRecursoSeguridad = null;
		if(oPerfilRecursoSeguridadEntity != null) {
			oPerfilRecursoSeguridad = new PerfilRecursoSeguridad();
			BeanUtils.copyProperties(oPerfilRecursoSeguridadEntity, oPerfilRecursoSeguridad);
		}
		return oPerfilRecursoSeguridad;
	}
	
	@Override
	public PerfilRecursoSeguridad findByIdPerfilAndIdRecursoSeguridad(Long idPerfil, Long idRecursoSeguridad) {
		PerfilRecursoSeguridadEntity oPerfilRecursoSeguridadEntity = perfilRecursoSeguridadJpaRepository.findByIdPerfilAndIdRecursoSeguridad(idPerfil, idRecursoSeguridad);
		PerfilRecursoSeguridad oPerfilRecursoSeguridad = null;
		if(oPerfilRecursoSeguridadEntity != null) {
			oPerfilRecursoSeguridad = new PerfilRecursoSeguridad();
			BeanUtils.copyProperties(oPerfilRecursoSeguridadEntity, oPerfilRecursoSeguridad);
		}
		return oPerfilRecursoSeguridad;
	}

	@Override
	public PerfilRecursoSeguridad create(PerfilRecursoSeguridad oPerfilRecursoSeguridad) {
		PerfilRecursoSeguridadEntity oPerfilRecursoSeguridadEntity = new PerfilRecursoSeguridadEntity();
        BeanUtils.copyProperties(oPerfilRecursoSeguridad, oPerfilRecursoSeguridadEntity);
        
        PerfilRecursoSeguridadEntity oPerfilRecursoSeguridadCreated = perfilRecursoSeguridadJpaRepository.save(oPerfilRecursoSeguridadEntity);
        oPerfilRecursoSeguridad.setIdPerfilRecursoSeguridad(oPerfilRecursoSeguridadCreated.getIdPerfilRecursoSeguridad());
        
		return oPerfilRecursoSeguridad;
	}

	@Override
	public void delete(Long id) {
		perfilRecursoSeguridadJpaRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		
		SQL oSql = new SQL();
		oSql.select("P.ID_PERFIL_RECURSO_SEGURIDAD");
		oSql.select("P.ID_PERFIL");
		oSql.select("P.ID_RECURSO_SEGURIDAD");
		oSql.select("P1.NOMBRE_PERFIL");
		oSql.select("R2.NOMBRE_RECURSO");

		oSql.from("PERFIL_RECURSO_SEGURIDAD P");
		oSql.from("LEFT JOIN PERFIL P1 ON P.ID_PERFIL = P1.ID_PERFIL");
		oSql.from("LEFT JOIN RECURSO_SEGURIDAD R2 ON P.ID_RECURSO_SEGURIDAD = R2.ID_RECURSO_SEGURIDAD");
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, pageNumber, pageSize);
		
		return mapResponse;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParametros, Integer pageNumber, Integer pageSize){ 
		
		SQL oSql = new SQL();
		oSql.select("P.ID_PERFIL_RECURSO_SEGURIDAD");
		oSql.select("P.ID_PERFIL");
		oSql.select("P.ID_RECURSO_SEGURIDAD");
		oSql.select("P1.NOMBRE_PERFIL");
		oSql.select("R2.NOMBRE_RECURSO");
		oSql.select("R2.CONTROL");

		oSql.from("PERFIL_RECURSO_SEGURIDAD P");
		oSql.from("LEFT JOIN PERFIL P1 ON P.ID_PERFIL = P1.ID_PERFIL");
		oSql.from("LEFT JOIN RECURSO_SEGURIDAD R2 ON P.ID_RECURSO_SEGURIDAD = R2.ID_RECURSO_SEGURIDAD");

		oSql.where("P.ID_PERFIL = ?", mapParametros.get("idPerfil"), Long.class);
		oSql.where("P.ID_RECURSO_SEGURIDAD = ?", mapParametros.get("idRecursoSeguridad"), Long.class);
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, oSql.getParametros(), pageNumber, pageSize);
		
		return mapResponse;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findRecursosByPerfil(Long idPerfil){ 
		SQL oSql = new SQL();
		oSql.select("P.ID_PERFIL_RECURSO_SEGURIDAD");
		oSql.select("P.ID_PERFIL");
		oSql.select("P.ID_RECURSO_SEGURIDAD");
		oSql.select("P1.NOMBRE_PERFIL");
		oSql.select("R2.NOMBRE_RECURSO");
		oSql.select("R2.CONTROL");

		oSql.from("PERFIL_RECURSO_SEGURIDAD P");
		oSql.from("LEFT JOIN PERFIL P1 ON P.ID_PERFIL = P1.ID_PERFIL");
		oSql.from("LEFT JOIN RECURSO_SEGURIDAD R2 ON P.ID_RECURSO_SEGURIDAD = R2.ID_RECURSO_SEGURIDAD");

		oSql.where("P.ID_PERFIL = ?", idPerfil.toString(), Long.class);
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, oSql.getParametros(), null, null);
		
		return mapResponse;
	}
}

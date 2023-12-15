package com.coop.infrastructure.repository.recursoSeguridad;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.dto.RecursoSeguridad;
import com.coop.domain.interfaces.recursoSeguridad.IRecursoSeguridadRepository;
import com.coop.infrastructure.entity.RecursoSeguridadEntity;
import com.coop.infrastructure.utils.DBUtil;
import com.coop.infrastructure.utils.SQL;

import org.springframework.beans.BeanUtils;

public class RecursoSeguridadRepositoryImp implements IRecursoSeguridadRepository{
	
	@Autowired
	private DBUtil dbUtil;
	
	IRecursoSeguridadJpaRepository recursoSeguridadJpaRepository;
	
	@Autowired
	public RecursoSeguridadRepositoryImp(IRecursoSeguridadJpaRepository recursoSeguridadJpaRepository) {
		this.recursoSeguridadJpaRepository = recursoSeguridadJpaRepository;
	}
	
	@Override
	public RecursoSeguridad findById(Long id) {
		RecursoSeguridadEntity oRecursoSeguridadEntity = recursoSeguridadJpaRepository.findById(id).orElse(null);
		RecursoSeguridad oRecursoSeguridad = null;
		if(oRecursoSeguridadEntity != null) {
			oRecursoSeguridad = new RecursoSeguridad();
			BeanUtils.copyProperties(oRecursoSeguridadEntity, oRecursoSeguridad);
		}
		return oRecursoSeguridad;
	}
	
	@Override
	public RecursoSeguridad findByControl(String control) {
		RecursoSeguridadEntity oRecursoSeguridadEntity = recursoSeguridadJpaRepository.findByControl(control);
		RecursoSeguridad oRecursoSeguridad = null;
		if(oRecursoSeguridadEntity != null) {
			oRecursoSeguridad = new RecursoSeguridad();
			BeanUtils.copyProperties(oRecursoSeguridadEntity, oRecursoSeguridad);
		}
		return oRecursoSeguridad;
	}

	@Override
	@Transactional
	public RecursoSeguridad create(RecursoSeguridad oRecursoSeguridad) {
		RecursoSeguridadEntity oRecursoSeguridadEntity = new RecursoSeguridadEntity();
        BeanUtils.copyProperties(oRecursoSeguridad, oRecursoSeguridadEntity);
        
        RecursoSeguridadEntity oRecursoSeguridadCreated = recursoSeguridadJpaRepository.save(oRecursoSeguridadEntity);
        oRecursoSeguridad.setIdRecursoSeguridad(oRecursoSeguridadCreated.getIdRecursoSeguridad());
        
		return oRecursoSeguridad;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		recursoSeguridadJpaRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		
		SQL oSql = new SQL();
		oSql.select("R.ID_RECURSO_SEGURIDAD");
		oSql.select("R.NOMBRE_RECURSO");
		oSql.select("R.CONTROL");

		oSql.from("RECURSO_SEGURIDAD R");
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, pageNumber, pageSize);
		
		return mapResponse;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParametros, int pageNumber, int pageSize){ 
		
		SQL oSql = new SQL();
		oSql.select("R.ID_RECURSO_SEGURIDAD");
		oSql.select("R.NOMBRE_RECURSO");
		oSql.select("R.CONTROL");

		oSql.from("RECURSO_SEGURIDAD R");

		oSql.where("R.NOMBRE_RECURSO = ?", mapParametros.get("nombreRecurso"), String.class);
		oSql.where("R.CONTROL = ?", mapParametros.get("control"), String.class);
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, oSql.getParametros(), pageNumber, pageSize);
		
		return mapResponse;
	}
}

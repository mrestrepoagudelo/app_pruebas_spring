package com.coop.infrastructure.repository.perfil;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.dto.Perfil;
import com.coop.domain.interfaces.perfil.IPerfilRepository;
import com.coop.infrastructure.entity.PerfilEntity;
import com.coop.infrastructure.utils.DBUtil;
import com.coop.infrastructure.utils.SQL;

import org.springframework.beans.BeanUtils;

public class PerfilRepositoryImp implements IPerfilRepository{
	
	@Autowired
	private DBUtil dbUtil;
	
	IPerfilJpaRepository perfilJpaRepository;
	
	@Autowired
	public PerfilRepositoryImp(IPerfilJpaRepository perfilJpaRepository) {
		this.perfilJpaRepository = perfilJpaRepository;
	}
	
	@Override
	public Perfil findById(Long id) {
		PerfilEntity oPerfilEntity = perfilJpaRepository.findById(id).orElse(null);
		Perfil oPerfil = null;
		if(oPerfilEntity != null) {
			oPerfil = new Perfil();
			BeanUtils.copyProperties(oPerfilEntity, oPerfil);
		}
		return oPerfil;
	}

	@Override
	public Perfil create(Perfil oPerfil) {
		PerfilEntity oPerfilEntity = new PerfilEntity();
        BeanUtils.copyProperties(oPerfil, oPerfilEntity);
        
        PerfilEntity oPerfilCreated = perfilJpaRepository.save(oPerfilEntity);
        oPerfil.setIdPerfil(oPerfilCreated.getIdPerfil());
        
		return oPerfil;
	}

	@Override
	public void delete(Long id) {
		perfilJpaRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		
		SQL oSql = new SQL();
		oSql.select("P.ID_PERFIL");
		oSql.select("P.NOMBRE_PERFIL");

		oSql.from("PERFIL P");
		oSql.where("P.NOMBRE_PERFIL <> 'ADMON'");
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, pageNumber, pageSize);
		
		return mapResponse;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParametros, int pageNumber, int pageSize){ 
		
		SQL oSql = new SQL();
		oSql.select("P.ID_PERFIL");
		oSql.select("P.NOMBRE_PERFIL");

		oSql.from("PERFIL P");

		oSql.where("P.NOMBRE_PERFIL = ?", mapParametros.get("nombrePerfil"), String.class);
		oSql.where("P.NOMBRE_PERFIL <> 'ADMON'");

		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, oSql.getParametros(), pageNumber, pageSize);
		
		return mapResponse;
	}
}

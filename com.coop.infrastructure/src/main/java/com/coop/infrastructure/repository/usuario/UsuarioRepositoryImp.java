package com.coop.infrastructure.repository.usuario;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coop.domain.dto.Usuario;
import com.coop.domain.interfaces.usuario.IUsuarioRepository;
import com.coop.infrastructure.entity.UsuarioEntity;
import com.coop.infrastructure.utils.DBUtil;
import com.coop.infrastructure.utils.SQL;

import org.springframework.beans.BeanUtils;

public class UsuarioRepositoryImp implements IUsuarioRepository{
	
	@Autowired
	private DBUtil dbUtil;
	
	IUsuarioJpaRepository usuarioJpaRepository;
	
	@Autowired
	public UsuarioRepositoryImp(IUsuarioJpaRepository usuarioJpaRepository) {
		this.usuarioJpaRepository = usuarioJpaRepository;
	}
	
	@Override
	public Usuario findById(Long id) {
		UsuarioEntity oUsuarioEntity = usuarioJpaRepository.findById(id).orElse(null);
		Usuario oUsuario = null;
		if(oUsuarioEntity != null) {
			oUsuario = new Usuario();
			BeanUtils.copyProperties(oUsuarioEntity, oUsuario);
		}
		return oUsuario;
	}
	
	@Override
	public Usuario findByUserName(String userName) {
		UsuarioEntity oUsuarioEntity = usuarioJpaRepository.findByUserName(userName);
		Usuario oUsuario = null;
		if(oUsuarioEntity != null) {
			oUsuario = new Usuario();
			BeanUtils.copyProperties(oUsuarioEntity, oUsuario);
		}
		return oUsuario;
	}

	@Override
	public Usuario create(Usuario oUsuario) {
		UsuarioEntity oPersonEntity = new UsuarioEntity();
        BeanUtils.copyProperties(oUsuario, oPersonEntity);
        
        UsuarioEntity oUsuarioCreated = usuarioJpaRepository.save(oPersonEntity);
        oUsuario.setIdUsuario(oUsuarioCreated.getIdUsuario());
        
		return oUsuario;
	}

	@Override
	public void delete(Long id) {
		usuarioJpaRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAll(int pageNumber,int pageSize) {
		Map<String,Object> mapResponse = new HashMap<>();
		
		SQL oSql = new SQL();
		oSql.select("U.ID_USUARIO");
		oSql.select("U.USER_NAME");
		oSql.select("U.CLAVE");
		oSql.select("U.ID_PERSONA");
		oSql.select("U.ID_PERFIL");
		oSql.select("U.ACTIVO");
		oSql.select("PE.NOMBRES");
		oSql.select("PF.NOMBRE_PERFIL");

		oSql.from("USUARIO U");
		oSql.from("LEFT JOIN PERSONA PE ON U.ID_PERSONA = PE.ID_PERSONA");
		oSql.from("LEFT JOIN PERFIL PF ON U.ID_PERFIL = PF.ID_PERFIL");
//		oSql.from("GROUP BY U.ID_USUARIO ORDER BY U.ID_USUARIO");
		
		mapResponse = dbUtil.findAll(oSql, pageNumber, pageSize);
		
		return mapResponse;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Map<String,Object> findAllFilters(Map<String,String> mapParametros, int pageNumber, int pageSize){ 
		
		SQL oSql = new SQL();
		oSql.select("US1.ID_USUARIO");
		oSql.select("US1.USER_NAME");
		oSql.select("US1.CLAVE");
		oSql.select("US1.ID_PERSONA");
		oSql.select("US1.ID_PERFIL");
		oSql.select("US1.ACTIVO");
		oSql.select("PE1.NOMBRES");
		oSql.select("PE2.NOMBRE_PERFIL");

		oSql.from("USUARIO US1");
		oSql.from("LEFT JOIN PERSONA PE1 ON US1.ID_PERSONA = PE1.ID_PERSONA");
		oSql.from("LEFT JOIN PERFIL PE2 ON US1.ID_PERFIL = PE2.ID_PERFIL");

		oSql.where("US1.USER_NAME LIKE ?", mapParametros.get("userName"), String.class);
		oSql.where("US1.CLAVE LIKE ?", mapParametros.get("clave"), String.class);
		oSql.where("US1.ID_PERSONA = ?", mapParametros.get("idPersona"), Long.class);
		oSql.where("US1.ID_PERFIL = ?", mapParametros.get("idPerfil"), Long.class);
		oSql.where("US1.ACTIVO = ?", mapParametros.get("activo"), String.class);
		
		Map<String,Object> mapResponse = new HashMap<>();
		mapResponse = dbUtil.findAll(oSql, oSql.getParametros(), pageNumber, pageSize);
		
		return mapResponse;
	}
}

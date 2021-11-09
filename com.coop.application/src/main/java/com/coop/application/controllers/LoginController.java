package com.coop.application.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coop.application.constants.Mapping;
import com.coop.domain.constants.MsgConstant;
import com.coop.domain.entities.Perfil;
import com.coop.domain.exception.ModelException;
import com.coop.domain.interfaces.perfil.IPerfilRepository;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadService;
import com.coop.infrastructure.entities.PerfilEntity;
import com.coop.infrastructure.entities.UsuarioEntity;
import com.coop.infrastructure.repository.perfil.IPerfilJpaRepository;
import com.coop.infrastructure.repository.usuario.IUsuarioJpaRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin("*")
@RestController
public class LoginController {
	
	@Autowired
	private IUsuarioJpaRepository usuarioRepository;
	
	@Autowired
	private IPerfilRecursoSeguridadService perfilRecursoSeguridadService;
	
	@Autowired
	private IPerfilJpaRepository perfilRepository;
	
	@PostMapping(Mapping.URL_LOGIN)
	public ResponseEntity<Map<String,Object>> login(@RequestBody Map<String,String> mapLogin) {
		
		UsuarioEntity oUsuario = validarLogin(mapLogin);
		Map<String,Object> mapResponse = new HashMap<String, Object>();
		String token = getJWTToken(oUsuario);
		
		mapResponse.put("usuario", oUsuario);
		mapResponse.put("token", token);
		mapResponse.put("permisos", getPermisos(oUsuario.getIdPerfil()));
		
		return ResponseEntity.status(HttpStatus.OK).body(mapResponse);
	}
	
	private UsuarioEntity validarLogin(Map<String,String> mapLogin) {
		String userName = mapLogin.get("userName");
		String clave = mapLogin.get("userPass");
		
		UsuarioEntity oUsuario = usuarioRepository.findByUserNameAndClave(userName,clave);
		if(oUsuario == null) {
			 throw new ModelException(MsgConstant.MSG_USUARIO_NO_ENCONTRADO);
		}
		else if (oUsuario.getActivo().equalsIgnoreCase("N")){
			throw new ModelException(MsgConstant.MSG_USUARIO_NO_ACTIVADO);
		}
		return oUsuario;
	}
	
	private Map<String,Object> getPermisos(Long idPerfil) {
		PerfilEntity oPerfil = perfilRepository.findById(idPerfil).orElse(null);
		
		if(oPerfil.getNombrePerfil().equalsIgnoreCase("ADMON")) {
			Map<String,Object> mapResponse = new HashMap<String, Object>();
			mapResponse.put("list","allPrivileges");
			return mapResponse;
		}
		
		Map<String,String> mapFilters = new HashMap<String, String>();
		mapFilters.put("idPerfil", idPerfil.toString());
		Map<String,Object> mapResponse = perfilRecursoSeguridadService.findAllFilters(mapFilters, null, null);	
		return mapResponse;
	}
	
	private String getJWTToken(UsuarioEntity oUsuario) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(oUsuario.getUserName())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.claim("idUsuario", oUsuario.getIdUsuario())
				.claim("idPerfil", oUsuario.getIdPerfil())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
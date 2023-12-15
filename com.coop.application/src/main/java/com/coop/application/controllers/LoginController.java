package com.coop.application.controllers;

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
import com.coop.domain.exception.ModelExceptionDos;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadService;
import com.coop.infrastructure.entity.UsuarioEntity;
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
	
	@PostMapping(Mapping.URL_LOGIN)
	public ResponseEntity<Map<String,Object>> login(@RequestBody Map<String,String> mapLogin) {
		UsuarioEntity oUsuario = validarLogin(mapLogin);
		Map<String,Object> mapResponse = new HashMap<String, Object>();
		String token = getJWTToken(oUsuario);
		
		mapResponse.put("usuario", oUsuario);
		mapResponse.put("token", token);
		mapResponse.put("recursosMenu", getRecursosByPerfil(oUsuario.getIdPerfil()));
		
		return ResponseEntity.status(HttpStatus.OK).body(mapResponse);
	}
	
	private UsuarioEntity validarLogin(Map<String,String> mapLogin) {
		String userName = mapLogin.get("userName");
		String clave = mapLogin.get("userPass");
		
		UsuarioEntity oUsuario = usuarioRepository.findByUserNameAndClave(userName,clave);
		if(oUsuario == null) {
			 throw new ModelExceptionDos(MsgConstant.MSG_USUARIO_NO_ENCONTRADO);
		}
		else if (oUsuario.getActivo().equalsIgnoreCase("N")){
			throw new ModelExceptionDos(MsgConstant.MSG_USUARIO_NO_ACTIVADO);
		}
		return oUsuario;
	}
	
	private Map<String, Object> getRecursosByPerfil(Long idPerfil) {
		return perfilRecursoSeguridadService.findRecursosByPerfil(idPerfil);
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
package com.coop.application.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coop.application.constants.Mapping;
import com.coop.domain.constants.MsgConstant;
import com.coop.domain.exception.ModelException;
import com.coop.domain.interfaces.perfilRecursoSeguridad.IPerfilRecursoSeguridadService;
import com.coop.infrastructure.entities.PerfilEntity;
import com.coop.infrastructure.entities.PerfilRecursoSeguridadEntity;
import com.coop.infrastructure.entities.RecursoSeguridadEntity;
import com.coop.infrastructure.repository.perfil.IPerfilJpaRepository;
import com.coop.infrastructure.repository.perfilRecursoSeguridad.IPerfilRecursoSeguridadJpaRepository;
import com.coop.infrastructure.repository.recursoSeguridad.IRecursoSeguridadJpaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "mySecretKey";
	private final String CONTROLLER_LOGIN = Mapping.URL_LOGIN;
	
	@Autowired
	private IPerfilRecursoSeguridadJpaRepository perfilRecursoSeguridadJpaRepository;
	
	@Autowired
	private IRecursoSeguridadJpaRepository recursoSeguridadJpaRepository;
	
	@Autowired
	private IPerfilJpaRepository perfilRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		try {
			if (existeJWTToken(request, response)) {
				
				Claims claims = validateToken(request);
				validarPermisos(claims,request);

				if (claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				} 
				else {
					SecurityContextHolder.clearContext();
				}
			} 
			else {
				SecurityContextHolder.clearContext();
			}
			
			chain.doFilter(request, response);
		} catch (UnsupportedJwtException | MalformedJwtException e ) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
		catch (ModelException e) {
			System.out.println(e.getMessage());
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(e.getMessage());
		}
	}
	
	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}
	
	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String control = request.getServletPath();
		String authenticationHeader = request.getHeader(HEADER);
		
		if(control.equalsIgnoreCase(CONTROLLER_LOGIN)) {
			return true;
		}
		
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	}
	
	private void validarPermisos(Claims claims, HttpServletRequest request) {
		String[] split_url = request.getServletPath().split("/");
		String control = split_url[2];
		String metodo = split_url[3];
		Long idPerfil = Long.parseLong(claims.get("idPerfil").toString());
		
//		PerfilEntity oPerfil = perfilRepository.findById(idPerfil).orElse(null);
//		if(oPerfil.getNombrePerfil().equalsIgnoreCase("ADMON")) {
//			Map<String,Object> mapResponse = new HashMap<String, Object>();
//			mapResponse.put("list","allPrivileges");
//			return mapResponse;
//		}
		
		if(true) {
			throw new ModelException("No tienes permisos!");
		}

		
		System.out.println("contro: "+control);
		
		RecursoSeguridadEntity oRecursoReguridad = recursoSeguridadJpaRepository.findByControl(control);
		System.out.println("idRecursoSeguridad: "+oRecursoReguridad.getIdRecursoSeguridad());
		System.out.println("idPerfil: "+idPerfil);
		
		PerfilRecursoSeguridadEntity oRecursoSeguridadEntity = perfilRecursoSeguridadJpaRepository.
				findByIdPerfilAndIdRecursoSeguridad(idPerfil, oRecursoReguridad.getIdRecursoSeguridad());
		System.out.println("*******************");
		System.out.println(oRecursoSeguridadEntity.getIdPerfilRecursoSeguridad());
		
		if(oRecursoSeguridadEntity != null) {
			
		}
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
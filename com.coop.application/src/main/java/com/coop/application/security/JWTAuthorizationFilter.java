package com.coop.application.security;

import java.io.IOException;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coop.application.exception.ErrorMessage;
import com.coop.domain.exception.ModelException;
import com.coop.infrastructure.entities.PerfilEntity;
import com.coop.infrastructure.entities.PerfilRecursoSeguridadEntity;
import com.coop.infrastructure.entities.RecursoSeguridadEntity;
import com.coop.infrastructure.repository.perfil.IPerfilJpaRepository;
import com.coop.infrastructure.repository.perfilRecursoSeguridad.IPerfilRecursoSeguridadJpaRepository;
import com.coop.infrastructure.repository.recursoSeguridad.IRecursoSeguridadJpaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "mySecretKey";
	
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
			ErrorMessage error = new ErrorMessage(e.getMessage(),HttpStatus.FORBIDDEN,null);
			restResponseBytes(error, response);
			return;
		}
		catch (ModelException e) {
			ErrorMessage error = new ErrorMessage(e.getMessage(),HttpStatus.UNAUTHORIZED,null);
			restResponseBytes(error, response);
            return;
		}
	}
	
	private void restResponseBytes(ErrorMessage error, HttpServletResponse response) throws IOException {
		byte[] responseToSend = new ObjectMapper().writeValueAsString(error).getBytes();
        ((HttpServletResponse) response).setHeader("Content-Type", "application/json");
        ((HttpServletResponse) response).setStatus(error.getHttpStatus().value());
        response.getOutputStream().write(responseToSend);
    }  
	
	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}
	
	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	}
	
	private void validarPermisos(Claims claims, HttpServletRequest request) {
		String[] split_url = request.getServletPath().split("/");
		String control = split_url[2];
		
//		if(control.equalsIgnoreCase("login")) {
//			return true;
//		}
		
		String metodo = split_url[3];
		Long idPerfil = Long.parseLong(claims.get("idPerfil").toString());
		
		RecursoSeguridadEntity oRecursoReguridad = recursoSeguridadJpaRepository.findByControl(control);
		PerfilRecursoSeguridadEntity oRecursoSeguridadEntity = perfilRecursoSeguridadJpaRepository.
				findByIdPerfilAndIdRecursoSeguridad(idPerfil, oRecursoReguridad.getIdRecursoSeguridad());
		
		PerfilEntity oPerfil = perfilRepository.findById(idPerfil).orElse(null);
		
		System.out.println(control);
		
		if(oPerfil.getNombrePerfil().equalsIgnoreCase("ADMON")) {
//			return true;
		}
		
		if(oRecursoSeguridadEntity == null) {
			throw new ModelException("No tienes permisos sobre ese recurso!");
		}
	}
	
	private static void findMissingNumbers(int arr[], int n)
    {
        int missCnt = n - arr.length;
        // create Bitset object b
        BitSet b = new BitSet(n);
        for (int i : arr) {
            b.set(i - 1);
        }
        int lastMissIndex = 0;
        for (int i = 0; i < missCnt; ++i) {
            lastMissIndex = b.nextClearBit(lastMissIndex);
            
            
            // print missing number
            System.out.println(++lastMissIndex);
        }
    }
	
    public static void main(String[] args)
    {
        // array of 10 numbers
        int[] A = new int[] { 1, 2,3, 4, 6, 8, 9 };
        
        int returnNumber = 0;
        int mayor = A[0];
		for (int x = 1; x < A.length; x++) {
			if (A[x] > mayor) {
				mayor = A[x];
			}
		}
        
        int missCnt = mayor - A.length;       
        BitSet b = new BitSet(mayor);
        for (int i : A) {
            b.set(i - 1);
        }
        int lastMissIndex = 0;
        for (int i = 0; i < missCnt; ++i) {
            lastMissIndex = b.nextClearBit(lastMissIndex);
            if(lastMissIndex > 0){
                returnNumber = ++lastMissIndex;
            }
            // System.out.println(++lastMissIndex);
            break;
        }
        System.out.println(returnNumber);
    }
	
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
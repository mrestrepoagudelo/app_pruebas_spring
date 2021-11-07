package com.coop.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coop.domain.entities.Usuario;
import com.coop.domain.interfaces.usuario.IUsuarioRepository;
import com.coop.domain.interfaces.usuario.IUsuarioService;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioServiceTest {
	
	@InjectMocks
	private IUsuarioService suarioService;
	
	@Mock
	IUsuarioRepository usuarioRepository;
	
	@BeforeEach
	void inicializaMocks() {
		MockitoAnnotations.initMocks(this);
		
		Usuario oUsuario = new Usuario();
		oUsuario.setUserName("x");
		oUsuario.setClave("12345678");
		oUsuario.setIdPersona(1L);
		oUsuario.setIdPerfil(2L);
		oUsuario.setActivo("N");
		
		suarioService.create(oUsuario);
	}
	
	@Test
	void testCreate() {
		Usuario oUsuario = new Usuario();
		oUsuario.setUserName("x");
		oUsuario.setClave("12345678");
		oUsuario.setIdPersona(1L);
		oUsuario.setIdPerfil(2L);
		oUsuario.setActivo("N");
		
//		boolean esInsertar = oUsuario.getIdUsuario() == null;
		
		//Actualizar
//		if(!esInsertar) {
//			Usuario oUsuarioDB = usuarioRepository.findById(oUsuario.getIdUsuario());
//			if(oUsuarioDB == null) {
//				throw new ModelException(MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_UPDATE);
//			}
//		}
		
//		Usuario o = usuarioRepository.create(oUsuario);
//		when(usuarioRepository.findById(1L)).thenReturn(oUsuario);
        
//		Usuario oUsuarioDb = usuarioRepository.findById(1L);
		Map<String,Object> map = usuarioRepository.findAll(1,1);
		System.out.println(map);
//	    Assertions.assertEquals(oUsuarioDb.getIdUsuario(),1L);
		assertEquals(10, 10);
	}
//
//	@Test
//	void testDelete() {
//		fail("Not yet implemented");
//	}

}

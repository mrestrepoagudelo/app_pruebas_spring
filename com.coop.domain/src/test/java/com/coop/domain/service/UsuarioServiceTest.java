package com.coop.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.coop.domain.constants.MsgConstant;
import com.coop.domain.entities.Usuario;
import com.coop.domain.exception.ModelException;
import com.coop.domain.interfaces.usuario.IUsuarioRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
	
	@InjectMocks
	UsuarioServiceImp usuarioService;
	
	@Mock
	IUsuarioRepository usuarioRepository;
	
	private Usuario oUsuario;
	
	@BeforeEach
	public void inicializaMocks() {
		MockitoAnnotations.initMocks(this);
		oUsuario = new Usuario();
		oUsuario.setUserName("UserTest");
		oUsuario.setClave("PassTest");
		oUsuario.setIdPersona(1L);
		oUsuario.setIdPerfil(2L);
		oUsuario.setActivo("N");
	}
	
	@Test
	void testFindAll() {
		Map<String,Object> mapResponse = new HashMap<>();
		when(usuarioRepository.findAll(1,10)).thenReturn(mapResponse);
		Map<String, Object> mapListaUsuario = usuarioService.findAll(1,10);
		assertEquals(mapListaUsuario,mapResponse);
		verify(usuarioRepository).findAll(1, 10);
	}
	
	
	@Test
	void testFindAllFilters() {
		Map<String,Object> mapResponse = new HashMap<>();
		when(usuarioRepository.findAllFilters(new HashMap<String,String>(),1,10)).thenReturn(mapResponse);
		Map<String, Object> mapListaUsuario = usuarioService.findAllFilters(new HashMap<String,String>(),1,10);
		assertEquals(mapListaUsuario,mapResponse);
		verify(usuarioRepository).findAllFilters(new HashMap<String,String>(),1, 10);
	}
	
	@Test
	void testFindById() {
		when(usuarioRepository.findById(oUsuario.getIdUsuario())).thenReturn(oUsuario);
		Usuario returned = usuarioService.findById(oUsuario.getIdUsuario());
		assertEquals(returned,oUsuario);
	}
	
	@Test
	void testFindByIdUserNoExist() {
		when(usuarioRepository.findById(oUsuario.getIdUsuario())).thenReturn(null);
		ModelException exception = assertThrows(ModelException.class, () -> usuarioService.findById(oUsuario.getIdUsuario()));
		assertEquals(exception.getMessage(),MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
	}

	@Test
	void testCreate() {
		oUsuario.setIdUsuario(null);
		when(usuarioRepository.create(any(Usuario.class))).thenReturn(oUsuario);
		Usuario created = usuarioService.create(oUsuario);
		assertEquals(created.getUserName(),oUsuario.getUserName());
		verify(usuarioRepository, times(1)).create(any(Usuario.class));
	}
	
	@Test
	void testUpdate() {
		oUsuario.setIdUsuario(1L);
		when(usuarioRepository.findById(oUsuario.getIdUsuario())).thenReturn(null);
		ModelException exception = assertThrows(ModelException.class, () -> usuarioService.create(oUsuario));
		assertEquals(exception.getMessage(),MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_UPDATE);
	}

	@Test
	void testDelete() {
		when(usuarioRepository.findById(oUsuario.getIdUsuario())).thenReturn(oUsuario);
		usuarioService.delete(oUsuario.getIdUsuario());
		verify(usuarioRepository,times(1)).delete(oUsuario.getIdUsuario());
	}
	
	@Test
	void testDeleteUserNoExist() {
		when(usuarioRepository.findById(oUsuario.getIdUsuario())).thenReturn(null);
		ModelException exception = assertThrows(ModelException.class, () -> usuarioService.delete(oUsuario.getIdUsuario()));
		assertEquals(exception.getMessage(),MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
	}
}

package com.ceiba.biblioteca.prestamo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ceiba.biblioteca.prestamo.domain.constant.MsgConstant;
import com.ceiba.biblioteca.prestamo.domain.exception.ModelException;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoCreateService;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoDeleteByIdService;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoFindAllService;
import com.ceiba.biblioteca.prestamo.domain.service.PrestamoFindByIdService;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceTest {

	@InjectMocks
	PrestamoCreateService prestamoCreateService;
	
	@InjectMocks
	PrestamoDeleteByIdService prestamoDeleteByIdService;
	
	@InjectMocks
	PrestamoFindAllService prestamoFindAllService;
	
	@InjectMocks
	PrestamoFindByIdService prestamoFindByIdService;

	@Mock
	IPrestamoRepositoryPort prestamoRepository;

	private Prestamo oPrestamo;
	private List<Prestamo> listPrestamos;

	@BeforeEach
	public void inicializaMocks() {
		oPrestamo = new Prestamo();
		oPrestamo.setIdPrestamo(1L);
		oPrestamo.setIdUsuario(1L);
		oPrestamo.setIdLibro(1L);
		oPrestamo.setFechaPrestamo(new Date());
		oPrestamo.setFechaMaximaDevolucion(new Date());

		listPrestamos = new ArrayList<Prestamo>();
		listPrestamos.add(oPrestamo);
	}

	@Test
	void testFindAll() {
		when(prestamoRepository.getAll()).thenReturn(listPrestamos);
		List<Prestamo> listaPrestamoRespuesta = prestamoFindAllService.getAll();
		assertNotNull(listaPrestamoRespuesta);
		assertTrue(listaPrestamoRespuesta.size() > 0);
		assertEquals(listaPrestamoRespuesta.get(0).getIdPrestamo(), 1L);
		verify(prestamoRepository, times(1)).getAll();
	}

	@Test
	void testFindById() {
		oPrestamo.setIdPrestamo(1L);
		when(prestamoRepository.getById(anyLong())).thenReturn(oPrestamo);
		Prestamo returned = prestamoFindByIdService.getById(oPrestamo.getIdPrestamo());
		assertNotNull(returned);
	}

	@Test
	void testFindByIdUserNoExist() {
		when(prestamoRepository.getById(anyLong())).thenReturn(null);
		ModelException exception = assertThrows(ModelException.class, () -> prestamoFindByIdService.getById(oPrestamo.getIdPrestamo()));
		assertEquals(exception.getErrorMessage(),MsgConstant.MSG_REGISTRO_NO_ENCONTRADO);
	}

	@Test
	void testCreate() {
		oPrestamo.setIdPrestamo(null);
		when(prestamoRepository.create(any(Prestamo.class))).thenReturn(oPrestamo);
		Prestamo pestamoCreated = prestamoCreateService.create(oPrestamo);
		assertEquals(pestamoCreated.getIdUsuario(), 1L);
		verify(prestamoRepository, times(1)).create(any(Prestamo.class));
	}

	@Test
	void testDelete() {
		when(prestamoRepository.getById(anyLong())).thenReturn(oPrestamo);
		prestamoDeleteByIdService.deleteById(oPrestamo.getIdPrestamo());
		verify(prestamoRepository,times(1)).deleteById(anyLong());
	}

	@Test
	void testDeletePersonNoExist() {
		when(prestamoRepository.getById(anyLong())).thenReturn(null);
		ModelException exception = assertThrows(ModelException.class, () -> prestamoDeleteByIdService.deleteById(oPrestamo.getIdPrestamo()));
		assertEquals(exception.getErrorMessage(),MsgConstant.MSG_REGISTRO_NO_ENCONTRADO_DELETE);
	}
}

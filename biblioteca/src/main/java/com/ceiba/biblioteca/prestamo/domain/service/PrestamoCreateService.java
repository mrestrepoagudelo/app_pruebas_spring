package com.ceiba.biblioteca.prestamo.domain.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.ceiba.biblioteca.prestamo.domain.constant.TipoUsuario;
import com.ceiba.biblioteca.prestamo.domain.exception.ModelException;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;
import com.ceiba.biblioteca.prestamo.domain.port.IPrestamoRepositoryPort;
import com.ceiba.biblioteca.prestamo.domain.utils.MDateUtil;
import com.ceiba.biblioteca.usuario.domain.constant.MsgConstant;
import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;
import com.ceiba.biblioteca.usuario.domain.port.IUsuarioRepositoryPort;

public class PrestamoCreateService {
	private final IPrestamoRepositoryPort prestamoRepository;
	private final IUsuarioRepositoryPort usuarioRepository;

	public PrestamoCreateService(IPrestamoRepositoryPort prestamoRepository, IUsuarioRepositoryPort usuarioRepository) {
		this.prestamoRepository = prestamoRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public Prestamo create(Prestamo oPrestamo) {
		Usuario usuario = usuarioRepository.getById(oPrestamo.getIdUsuario());
		if (usuario == null) {
			throw new ModelException(MsgConstant.MSG_USUARIO_NO_ENCONTRADO);
		}

		LocalDate fechaPrestamo = MDateUtil.getLocalDateNow();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaMaximaDevolucion = getFechaMaximaDevolucionTipoUsuario(fechaPrestamo, usuario.getIdTipoUsuario());
		
		oPrestamo.setFechaPrestamo(MDateUtil.convertirEnDate(fechaPrestamo));
		oPrestamo.setFechaMaximaDevolucion(MDateUtil.convertirEnDate(fechaMaximaDevolucion));

		return prestamoRepository.create(oPrestamo);
	}

	private LocalDate getFechaMaximaDevolucionTipoUsuario(LocalDate fechaPrestamo, Long idTipoUsuario) {
		if (TipoUsuario.USUARIO_AFILIADO == idTipoUsuario.intValue()) {
			return MDateUtil.addBusinessDays(fechaPrestamo, 10, Optional.empty());
		} else if (TipoUsuario.USUARIO_EMPLEADO == idTipoUsuario.intValue()) {
			return MDateUtil.addBusinessDays(fechaPrestamo, 8, Optional.empty());
		} else if (TipoUsuario.USUARIO_INVITADO == idTipoUsuario.intValue()) {
			return MDateUtil.addBusinessDays(fechaPrestamo, 7, Optional.empty());
		} else {
			throw new ModelException(MsgConstant.MSG_TIPO_USUARIO_INVALIDO);
		}
	}
}

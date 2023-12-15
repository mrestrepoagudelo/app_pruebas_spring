package com.ceiba.biblioteca.prestamo.aplicacion.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDto;
import com.ceiba.biblioteca.prestamo.domain.model.dto.PrestamoDtoResponseCreated;
import com.ceiba.biblioteca.prestamo.domain.model.entity.Prestamo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrestamoDtoMapper {
	@Mapping(source = "idPrestamo", target = "id")
	@Mapping(source = "fechaMaximaDevolucion", target = "fechaMaximaDevolucion")
	PrestamoDtoResponseCreated toDtoResponseCreated(Prestamo domain);

	PrestamoDto toDto(Prestamo domain);
	
	Prestamo toDomain(PrestamoDto entity);
}

package com.ceiba.biblioteca.usuario.domain.port;

import java.util.List;

import com.ceiba.biblioteca.usuario.domain.model.entity.Usuario;

public interface IUsuarioRepositoryPort {
	public Usuario create(Usuario persona);

	public Usuario getById(Long id);

	public List<Usuario> getAll();

	public void deleteById(Long id);

	public Usuario findByNumeroIdentificacion(String numeroIdentificacion);

}

package com.springboot.datajpa.apirest.models.dao;

import java.util.List;

import com.springboot.datajpa.apirest.models.entity.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> findAll(); 
	
	public Usuario getById(Long id); 
	
	public void save(Usuario usuario);
	
	public void edit(Usuario usuario);
	
	public void delete(Long id);

}

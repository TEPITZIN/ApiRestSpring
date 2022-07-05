package com.springboot.datajpa.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.datajpa.apirest.models.dao.UsuarioDao;
import com.springboot.datajpa.apirest.models.entity.Usuario;
import com.springboot.datajpa.apirest.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.getById(id);
	}

	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.save(usuario);

	}

	@Override
	public void edit(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.edit(usuario);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.delete(id);

	}

}

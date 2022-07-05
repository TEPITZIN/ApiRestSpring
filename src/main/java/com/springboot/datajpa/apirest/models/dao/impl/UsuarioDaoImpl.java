package com.springboot.datajpa.apirest.models.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.datajpa.apirest.models.dao.UsuarioDao;
import com.springboot.datajpa.apirest.models.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager emUsuario;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		return emUsuario.createQuery("from Usuario").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario getById(Long id) {
		return emUsuario.find(Usuario.class, id);
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		emUsuario.persist(usuario);
		
	}

	@Override
	@Transactional
	public void edit(Usuario usuario) {
		emUsuario.merge(usuario);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Usuario usuario=getById(id);
		emUsuario.remove(usuario);
		
	}

}

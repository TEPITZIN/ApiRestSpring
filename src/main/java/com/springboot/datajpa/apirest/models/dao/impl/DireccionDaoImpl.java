package com.springboot.datajpa.apirest.models.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.datajpa.apirest.models.dao.DireccionDao;
import com.springboot.datajpa.apirest.models.entity.Direccion;

@Repository
public class DireccionDaoImpl implements DireccionDao {

	@PersistenceContext
	private EntityManager emDireccion;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Direccion> findAll() {
		return emDireccion.createQuery("from Direccion").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Direccion getById(Integer id) {
		return emDireccion.find(Direccion.class, id);
	}

	@Override
	@Transactional
	public void save(Direccion direccion) {
		emDireccion.persist(direccion);
		
	}

	@Override
	@Transactional
	public void edit(Direccion direccion) {
		emDireccion.merge(direccion);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Direccion direccion=getById(id);
		emDireccion.remove(direccion);
		
	}

}

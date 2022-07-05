package com.springboot.datajpa.apirest.models.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.datajpa.apirest.models.dao.CuentaDao;
import com.springboot.datajpa.apirest.models.entity.Cuenta;

@Repository
public class CuentaDaoImpl implements CuentaDao {

	@PersistenceContext
	private EntityManager emCuenta;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cuenta> findAll() {
		return emCuenta.createQuery("from Cuenta").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta getById(Integer id) {
		return emCuenta.find(Cuenta.class, id);
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		emCuenta.persist(cuenta);
		
	}

	@Override
	@Transactional
	public void edit(Cuenta cuenta) {
		emCuenta.merge(cuenta);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Cuenta cuenta=getById(id);
		emCuenta.remove(cuenta);
		
	}

}

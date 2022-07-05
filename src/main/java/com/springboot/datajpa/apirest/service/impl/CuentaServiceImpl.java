package com.springboot.datajpa.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.datajpa.apirest.models.dao.CuentaDao;
import com.springboot.datajpa.apirest.models.entity.Cuenta;
import com.springboot.datajpa.apirest.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaDao cuentaDao;
	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return cuentaDao.findAll();
	}

	@Override
	public Cuenta getById(Integer id) {
		// TODO Auto-generated method stub
		return cuentaDao.getById(id);
	}

	@Override
	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaDao.save(cuenta);

	}

	@Override
	public void edit(Cuenta cuenta) {
		// TODO Auto-generated method stub
		cuentaDao.edit(cuenta);

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		cuentaDao.delete(id);

	}

}

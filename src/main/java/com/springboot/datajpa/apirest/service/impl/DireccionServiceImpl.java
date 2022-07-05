package com.springboot.datajpa.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.datajpa.apirest.models.dao.DireccionDao;
import com.springboot.datajpa.apirest.models.entity.Direccion;
import com.springboot.datajpa.apirest.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	private DireccionDao direccionDao;
	@Override
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return direccionDao.findAll();
	}

	@Override
	public Direccion getById(Integer id) {
		// TODO Auto-generated method stub
		return direccionDao.getById(id);
	}

	@Override
	public void save(Direccion direccion) {
		// TODO Auto-generated method stub
		direccionDao.save(direccion);
	}

	@Override
	public void edit(Direccion direccion) {
		// TODO Auto-generated method stub
		direccionDao.edit(direccion);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		direccionDao.delete(id);
	}

}

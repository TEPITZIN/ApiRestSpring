package com.springboot.datajpa.apirest.models.dao;

import java.util.List;

import com.springboot.datajpa.apirest.models.entity.Cuenta;

public interface CuentaDao {
	
	public List<Cuenta> findAll();
	
	public Cuenta  getById(Integer id);
	
	public void save(Cuenta cuenta);
	
	public void edit(Cuenta cuenta);
	
	public void delete(Integer id);

}

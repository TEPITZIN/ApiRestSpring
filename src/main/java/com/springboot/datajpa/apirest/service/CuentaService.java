package com.springboot.datajpa.apirest.service;

import java.util.List;

import com.springboot.datajpa.apirest.models.entity.Cuenta;

public interface CuentaService {
	
	public List<Cuenta> findAll();
	
	public Cuenta  getById(Integer id);
	
	public void save(Cuenta cuenta);
	
	public void edit(Cuenta cuenta);
	
	public void delete(Integer id);

}

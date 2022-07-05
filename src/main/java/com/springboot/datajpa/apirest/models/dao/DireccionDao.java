package com.springboot.datajpa.apirest.models.dao;

import java.util.List;

import com.springboot.datajpa.apirest.models.entity.Direccion;

public interface DireccionDao {
	
	public List<Direccion> findAll();
	
	public Direccion getById(Integer id);
	
	public void save(Direccion direccion);
	
	public void edit(Direccion direccion);
	
	public void delete(Integer id);

}

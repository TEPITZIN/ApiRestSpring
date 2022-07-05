package com.springboot.datajpa.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.datajpa.apirest.models.entity.Usuario;
import com.springboot.datajpa.apirest.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
		
	}
	
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		Usuario usuario=null;
		try {
			usuario=usuarioService.getById(id);
		}catch(DataAccessException e) {
			response.put("error", e.getMessage());
			response.put("mensaje", "Hubo un error al realiza la consulta a la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(usuario==null) {
			response.put("mensaje", "El usuario no fue localizado");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult validacionResultado) {
		Map<String, Object> response = new HashMap<>();
		
		if(validacionResultado.hasErrors() 
				|| usuario.getDireccion().getCodigoPostal().toString().length() != 6
				|| usuario.getCuenta().getNumeroCuenta().toString().length() != 10) {
			List<String> errores= new ArrayList<>();
			for(FieldError error: validacionResultado.getFieldErrors()) {
				errores.add("El campo "+error.getField()+" "+error.getDefaultMessage());
			}
			
			//Campo cuenta debe de tener 10 digitos
			//Campo codigoPostal debe detener 6 digitos
			if(usuario.getCuenta().getNumeroCuenta().toString().length() != 10) {
				errores.add("El campo numeroCuenta debe de contener una longitud de 10");
			}
			
			if(usuario.getDireccion().getCodigoPostal().toString().length() != 6) {
				errores.add("El campo codigoPostal debe de contener una longitud de 6");
			}
			
			response.put("errors", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			usuarioService.save(usuario);
			response.put("mensaje", "El usuario fue guardado correctamente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch(DataAccessException e) {
			response.put("error", e.getMessage());
			response.put("mensaje", "Hubo un error al insertar el usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/usuarios/update")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult validacionResultado) {
		Map<String, Object> response = new HashMap<>();
		if(validacionResultado.hasErrors() 
				|| usuario.getDireccion().getCodigoPostal().toString().length() != 6
				|| usuario.getCuenta().getNumeroCuenta().toString().length() != 10) {
			List<String> errores= new ArrayList<>();
			for(FieldError error: validacionResultado.getFieldErrors()) {
				errores.add("El campo "+error.getField()+" "+error.getDefaultMessage());
			}
			
			//Campo cuenta debe de tener 10 digitos
			//Campo codigoPostal debe detener 6 digitos
			if(usuario.getCuenta().getNumeroCuenta().toString().length() != 10) {
				errores.add("El campo numeroCuenta debe de ser contener una longitud de 10");
			}
			
			if(usuario.getDireccion().getCodigoPostal().toString().length() != 6) {
				errores.add("El campo numeroCuenta debe de ser contener una longitud de 10");
			}
			
			response.put("errors", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			usuarioService.edit(usuario);
			response.put("mensaje", "El usuario fue modificado correctamente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch(DataAccessException e) {
			response.put("error", e.getMessage());
			response.put("mensaje", "Hubo un error al modificar el usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioService.delete(id);
			response.put("mensaje", "El usuario fue eliminado correctamente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch(DataAccessException e) {
			response.put("error", e.getMessage());
			response.put("mensaje", "Hubo un error al eliminar el usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

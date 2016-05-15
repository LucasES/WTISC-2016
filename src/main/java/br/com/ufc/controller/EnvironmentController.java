package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.Environment;
import br.com.ufc.service.IEnvironmentService;

@RestController
@RequestMapping(value = "/ambientes")
public class EnvironmentController {

	@Autowired
	private IEnvironmentService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Environment>> findAll() {
		List<Environment> environmentList = service.findAll();
		
		return new ResponseEntity<List<Environment>>(environmentList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Environment> findOne(@PathVariable int id){
		Environment environment = service.findOne(id);
		
		return new ResponseEntity<Environment>(environment, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Environment> save(@RequestBody Environment requestEnvironment){
		Environment environment = service.save(requestEnvironment);
		
		return new ResponseEntity<Environment>(environment, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Environment> update(@PathVariable int id, @RequestBody Environment requestEnvironment){
		requestEnvironment.setId(Long.valueOf(id));

		Environment environment = service.update(requestEnvironment);
		
		return new ResponseEntity<Environment>(environment, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

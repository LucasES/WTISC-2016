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

import br.com.ufc.model.EnvironmentType;
import br.com.ufc.service.IEnvironmentTypeService;

@RestController
@RequestMapping(value = "/ambientes/tipos")
public class EnvironmentTypeController {

	@Autowired
	private IEnvironmentTypeService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EnvironmentType>> findAll() {
		List<EnvironmentType> environmentTypeList = service.findAll();

		return new ResponseEntity<List<EnvironmentType>>(environmentTypeList, HttpStatus.OK);
	}

	/**
	 * Exemplo de acesso: https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EnvironmentType> findOne(@PathVariable int id) {
		EnvironmentType environmentType = service.findOne(id);

		return new ResponseEntity<EnvironmentType>(environmentType, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EnvironmentType> save(@RequestBody EnvironmentType requestEnvironmentType) {
		EnvironmentType environmentType = service.save(requestEnvironmentType);

		return new ResponseEntity<EnvironmentType>(environmentType, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EnvironmentType> update(@PathVariable int id,
			@RequestBody EnvironmentType requestEnvironmentType) {
		requestEnvironmentType.setId(Long.valueOf(id));

		EnvironmentType environmentType = service.update(requestEnvironmentType);

		return new ResponseEntity<EnvironmentType>(environmentType, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

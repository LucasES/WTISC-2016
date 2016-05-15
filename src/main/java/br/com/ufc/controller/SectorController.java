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

import br.com.ufc.model.Sector;
import br.com.ufc.service.ISectorService;

@RestController
@RequestMapping(value = "/setores")
public class SectorController {

	@Autowired
	private ISectorService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sector>> findAll() {
		List<Sector> sectorList = service.findAll();
		
		return new ResponseEntity<List<Sector>>(sectorList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sector> findOne(@PathVariable int id){
		Sector sector = service.findOne(id);
		
		return new ResponseEntity<Sector>(sector, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Sector> save(@RequestBody Sector requestSector){
		Sector sector = service.save(requestSector);
		
		return new ResponseEntity<Sector>(sector, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Sector> update(@PathVariable int id, @RequestBody Sector requestSector){
		requestSector.setId(Long.valueOf(id));

		Sector sector = service.update(requestSector);
		
		return new ResponseEntity<Sector>(sector, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

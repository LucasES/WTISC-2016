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

import br.com.ufc.model.Buy;
import br.com.ufc.service.IBuyService;

@RestController
@RequestMapping(value = "/compras")
public class BuyController {

	@Autowired
	private IBuyService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Buy>> findAll() {
		List<Buy> buyList = service.findAll();
		
		return new ResponseEntity<List<Buy>>(buyList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Buy> findOne(@PathVariable int id){
		Buy buy = service.findOne(id);
		
		return new ResponseEntity<Buy>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Buy> save(@RequestBody Buy RequestBuy){
		Buy buy = service.save(RequestBuy);
		
		return new ResponseEntity<Buy>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Buy> update(@PathVariable int id, @RequestBody Buy requestBuy){
		requestBuy.setId(Long.valueOf(id));

		Buy buy = service.update(requestBuy);
		
		return new ResponseEntity<Buy>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

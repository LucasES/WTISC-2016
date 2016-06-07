package br.com.ufc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.Buy;
import br.com.ufc.service.IBuyService;

@RestController
@RequestMapping(value = "/compras")
public class BuyController {

	@Autowired
	private IBuyService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Buy>> findAll(){
		
		List<Buy> buyList = service.findAll();
		
		return new ResponseEntity<List<Buy>>(buyList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Buy> findOne(
			@PathVariable(value = "id") Long id) {
		
		Buy buy = service.findOne(id);
		
		return new ResponseEntity<Buy>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/maior/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<List<Buy>> quantityBuyMoreThan(
			@PathVariable(value = "quantity") int quantity) {
		
		List<Buy> buyList = service.buyQuantityGreaterThan(quantity);
		
		return new ResponseEntity<List<Buy>>(buyList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/entre", method = RequestMethod.GET)
	public ResponseEntity<List<Buy>> buyBetween(
			@RequestParam(value = "fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate,
			@RequestParam(value = "toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate,
			@RequestParam(value = "active", required = true, defaultValue = "true") boolean active) {
		
		List<Buy> buyList = service.allBuyBetween(fromDate, toDate,active);
		
		return new ResponseEntity<List<Buy>>(buyList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Buy> save(@RequestBody Buy requestBuy) {
		
		Buy buy = service.save(requestBuy);
		
		return new ResponseEntity<Buy>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Buy> update(
			@PathVariable(value = "id") Long id, 
			@RequestBody Buy requestBuy){
		
		Buy buy = service.update(requestBuy);
		
		return new ResponseEntity<Buy>(buy, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable(value = "id") Long id) {
		
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}






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

import br.com.ufc.model.Event;
import br.com.ufc.service.IEventService;

@RestController
@RequestMapping(value = "/eventos")
public class EventController {

	@Autowired
	private IEventService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Event>> findAll() {
		List<Event> eventList = service.findAll();
		
		return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Event> findOne(@PathVariable int id){
		Event event = service.findOne(id);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Event> save(@RequestBody Event requestEvent){
		Event event = service.save(requestEvent);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Event> update(@PathVariable int id, @RequestBody Event requestEvent){
		requestEvent.setId(Long.valueOf(id));

		Event event = service.update(requestEvent);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

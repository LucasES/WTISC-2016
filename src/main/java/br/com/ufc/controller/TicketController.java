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

import br.com.ufc.model.Ticket;
import br.com.ufc.service.ITicketService;

@RestController
@RequestMapping(value = "/ingressos")
public class TicketController {

	@Autowired
	private ITicketService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> findAll() {
		List<Ticket> ticketList = service.findAll();
		
		return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ticket> findOne(@PathVariable int id){
		Ticket ticket = service.findOne(id);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Ticket> save(@RequestBody Ticket requestTicket){
		Ticket ticket = service.save(requestTicket);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ticket> update(@PathVariable int id, @RequestBody Ticket requestTicket){
		requestTicket.setId(Long.valueOf(id));

		Ticket ticket = service.update(requestTicket);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

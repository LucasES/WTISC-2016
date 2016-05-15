package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Ticket;

public interface ITicketService {

	public List<Ticket> findAll();
	
	public Ticket findOne(long id);
	
	public Ticket save(Ticket ticket);
	
	public Ticket update(Ticket ticket);
	
	public void delete(long id);
}

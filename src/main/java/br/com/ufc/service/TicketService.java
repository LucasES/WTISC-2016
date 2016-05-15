package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Ticket;
import br.com.ufc.repository.TicketRepository;

@Service
@Transactional
public class TicketService implements ITicketService{

	@Autowired
	private TicketRepository repository;
	
	@Override
	public List<Ticket> findAll() {
		return repository.findAll();
	}

	@Override
	public Ticket findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket update(Ticket ticket) {
		
		if(!(repository.exists(ticket.getId()))){
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(ticket);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}

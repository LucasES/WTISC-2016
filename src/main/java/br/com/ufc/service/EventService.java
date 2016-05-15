package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Event;
import br.com.ufc.repository.EventRepository;

@Service
@Transactional
public class EventService implements IEventService{

	@Autowired
	private EventRepository repository;
	
	@Override
	public List<Event> findAll() {
		return repository.findAll();
	}

	@Override
	public Event findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Event save(Event event) {
		return repository.save(event);
	}

	@Override
	public Event update(Event event) {
		
		if(!(repository.exists(event.getId()))){
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(event);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

	
}

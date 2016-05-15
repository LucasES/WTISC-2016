package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Event;

public interface IEventService {

	public List<Event> findAll();
	
	public Event findOne(long id);
	
	public Event save(Event event);
	
	public Event update(Event event);
	
	public void delete(long id);
}

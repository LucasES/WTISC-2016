package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Environment;

public interface IEnvironmentService {

	public List<Environment> findAll();
	
	public Environment findOne(long id);
	
	public Environment save(Environment environment);
	
	public Environment update(Environment environment);
	
	public void delete(long id); 
}

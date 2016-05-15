package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.EnvironmentType;

public interface IEnvironmentTypeService {

	public List<EnvironmentType> findAll();
	
	public EnvironmentType findOne(long id);
	
	public EnvironmentType save(EnvironmentType environmentType);
	
	public EnvironmentType update(EnvironmentType environmentType);
	
	public void delete(long id);
}

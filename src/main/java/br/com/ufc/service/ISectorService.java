package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Sector;

public interface ISectorService {

	public List<Sector> findAll();
	
	public Sector findOne(long id);
	
	public Sector save(Sector sector);

	public Sector update(Sector sector);
	
	public void delete(long id);
	
}

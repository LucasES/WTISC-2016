package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Buy;

public interface IBuyService {

	public List<Buy> findAll();
	
	public Buy findOne(long id);
	
	public Buy save(Buy buy);
	
	public Buy update(Buy buy);
	
	public void delete(long id);
}

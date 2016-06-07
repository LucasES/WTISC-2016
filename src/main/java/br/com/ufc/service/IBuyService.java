package br.com.ufc.service;

import java.util.Date;
import java.util.List;

import br.com.ufc.model.Buy;

public interface IBuyService {

	public List<Buy> findAll();
	
	public Buy findOne(long id);
	
	public Buy save(Buy buy);

	public Buy update(Buy buy);
	
	public void delete(long id);
	
	public List<Buy> buyQuantityGreaterThan(int quantity);
	
	public List<Buy> allBuyBetween(Date fromDate, Date toDate, boolean active);
}

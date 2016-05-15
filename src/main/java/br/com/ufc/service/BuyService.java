package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Buy;
import br.com.ufc.repository.BuyRepository;

@Service
@Transactional
public class BuyService implements IBuyService{
	
	@Autowired
	private BuyRepository repository;
	
	@Override
	public List<Buy> findAll() {
		return repository.findAll();
	}

	@Override
	public Buy findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Buy save(Buy buy) {
		return repository.save(buy);
	}

	@Override
	public Buy update(Buy buy) {
		
		if (!(repository.exists(buy.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(buy);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}
}

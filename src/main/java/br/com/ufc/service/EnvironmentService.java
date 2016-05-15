package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Environment;
import br.com.ufc.repository.EnvironmentRepository;

@Service
@Transactional
public class EnvironmentService implements IEnvironmentService{

	@Autowired
	private EnvironmentRepository repository;
	
	@Override
	public List<Environment> findAll() {
		return repository.findAll();
	}

	@Override
	public Environment findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Environment save(Environment environment) {
		return repository.save(environment);
	}

	@Override
	public Environment update(Environment environment) {
		
		if(!(repository.exists(environment.getId()))){
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(environment);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}

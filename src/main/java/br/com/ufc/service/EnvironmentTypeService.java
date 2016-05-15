package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.EnvironmentType;
import br.com.ufc.repository.EnvironmentTypeRepository;

@Service
@Transactional
public class EnvironmentTypeService implements IEnvironmentTypeService{

	@Autowired
	private EnvironmentTypeRepository repository; 
	
	@Override
	public List<EnvironmentType> findAll() {
		return repository.findAll();
	}

	@Override
	public EnvironmentType findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public EnvironmentType save(EnvironmentType environmentType) {
		return repository.save(environmentType);
	}

	@Override
	public EnvironmentType update(EnvironmentType environmentType) {

		if(!(repository.exists(environmentType.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(environmentType);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}

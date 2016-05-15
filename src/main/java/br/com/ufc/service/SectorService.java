package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Sector;
import br.com.ufc.repository.SectorRepository;

@Service
@Transactional
public class SectorService implements ISectorService{

	@Autowired
	private SectorRepository repository;
	
	@Override
	public List<Sector> findAll() {
		return repository.findAll();
	}

	@Override
	public Sector findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Sector save(Sector sector) {
		return repository.save(sector);
	}

	@Override
	public Sector update(Sector sector) {

		if(!(repository.exists(sector.getId()))){
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(sector);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}

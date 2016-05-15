package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Category;
import br.com.ufc.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}

	@Override
	public Category findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Category save(Category category) {
		return repository.save(category);
	}

	@Override
	public Category update(Category category) {
		
		if(!(repository.exists(category.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(category);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}

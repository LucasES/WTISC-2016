package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Category;

public interface ICategoryService {

	public List<Category> findAll();
	
	public Category findOne(long id);
	
	public Category save(Category category);
	
	public Category update(Category category);
	
	public void delete(long id);
}

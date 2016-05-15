package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.model.Category;
import br.com.ufc.service.ICategoryService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryController {

	@Autowired
	private ICategoryService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categoryList = service.findAll();

		return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
	}

	/**
	 * Exemplo de acesso: https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> findOne(@PathVariable int id) {
		Category category = service.findOne(id);

		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Category> save(@RequestBody Category requestCategory) {
		Category category = service.save(requestCategory);

		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@PathVariable int id, @RequestBody Category requestCategory) {
		requestCategory.setId(Long.valueOf(id));

		Category category = service.update(requestCategory);

		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

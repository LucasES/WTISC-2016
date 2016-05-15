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

import br.com.ufc.model.User;
import br.com.ufc.service.IUserService;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> userList = service.findAll();
		
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable int id){
		User user = service.findOne(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User requestUser){
		User user = service.save(requestUser);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * Atualiza um usuário.
	 * 
	 * @param id
	 * @param requestUser
	 * @return Se executado com sucesso, devolve uma respota HTTP com o usuário
	 *         e status 200.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User requestUser) {
		requestUser.setId(Long.valueOf(id));

		User user = service.update(requestUser);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

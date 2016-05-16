package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.User;

public interface IUserService {

	public List<User> findAll();
	
	public User findOne(long id);
	
	public User findByEmailAdress(String email);
	
	public List<User> findByName(String name);
	
	public User save(User user);
	
	public User update(User user);
	
	public void delete(long id);
}

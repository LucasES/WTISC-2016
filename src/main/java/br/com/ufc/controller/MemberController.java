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

import br.com.ufc.model.Member;
import br.com.ufc.service.IMemberService;

@RestController
@RequestMapping(value = "/integrantes")
public class MemberController {

	@Autowired
	private IMemberService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Member>> findAll() {
		List<Member> memberList = service.findAll();
		
		return new ResponseEntity<List<Member>>(memberList, HttpStatus.OK);
	}
	
	
	/**
	 * Exemplo de acesso:
	 * https://localhost:8080/compras/1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Member> findOne(@PathVariable int id){
		Member member = service.findOne(id);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Member> save(@RequestBody Member requestMember){
		Member member = service.save(requestMember);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Member> update(@PathVariable int id, @RequestBody Member requestMember){
		requestMember.setId(Long.valueOf(id));

		Member member = service.update(requestMember);
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

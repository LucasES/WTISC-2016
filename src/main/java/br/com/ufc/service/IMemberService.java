package br.com.ufc.service;

import java.util.List;

import br.com.ufc.model.Member;

public interface IMemberService {

	public List<Member> findAll();
	
	public Member findOne(long id);
	
	public Member save(Member member);
	
	public Member update(Member member);
	
	public void delete(long id);
}

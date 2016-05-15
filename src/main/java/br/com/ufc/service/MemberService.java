package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufc.model.Member;
import br.com.ufc.repository.MemberRepository;

@Service
@Transactional
public class MemberService implements IMemberService{

	@Autowired
	private MemberRepository repository;
	
	@Override
	public List<Member> findAll() {
		return repository.findAll();
	}

	@Override
	public Member findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Member save(Member member) {
		return repository.save(member);
	}

	@Override
	public Member update(Member member) {
		
		if(!(repository.exists(member.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(member);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

}

package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}

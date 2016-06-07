package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long>, JpaSpecificationExecutor<Buy>{

}

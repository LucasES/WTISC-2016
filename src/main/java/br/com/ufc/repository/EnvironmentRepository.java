package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Environment;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long>{

}

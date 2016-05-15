package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.EnvironmentType;

@Repository
public interface EnvironmentTypeRepository extends JpaRepository<EnvironmentType, Long>{

}

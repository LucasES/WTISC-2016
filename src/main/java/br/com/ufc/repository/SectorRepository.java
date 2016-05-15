package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long>{

}

package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}

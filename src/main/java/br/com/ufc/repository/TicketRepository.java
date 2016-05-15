package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}

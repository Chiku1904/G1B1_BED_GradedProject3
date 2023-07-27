package com.greatlearning.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "select * from Ticket t where t.Ticket_Title = :keyword OR t.Ticket_Description = :keyword", nativeQuery = true)
	List<Ticket> searchByKeyword(@RequestParam("keyword") String keyword);
}

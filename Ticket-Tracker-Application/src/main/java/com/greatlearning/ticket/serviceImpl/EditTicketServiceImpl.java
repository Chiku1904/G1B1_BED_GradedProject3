package com.greatlearning.ticket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.repository.TicketRepository;
import com.greatlearning.ticket.service.EditTicketService;
@Service
public class EditTicketServiceImpl implements EditTicketService{

	@Autowired
	TicketRepository ticketTrackerRepository;
	
	@Override
	public Object editTicket(long id, Ticket ticket) {
		Ticket tick = new Ticket();
		tick.setId(id);
		tick.setTicketTitle(ticket.getTicketTitle());
		tick.setTicketDescription(ticket.getTicketDescription());
		tick.setContent(ticket.getContent());
		tick.setDate(ticket.getDate());
		return ticketTrackerRepository.save(tick);
	}
}

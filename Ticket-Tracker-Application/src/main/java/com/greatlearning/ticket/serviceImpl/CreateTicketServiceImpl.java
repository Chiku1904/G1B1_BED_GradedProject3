package com.greatlearning.ticket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.repository.TicketRepository;
import com.greatlearning.ticket.service.CreateTicketService;
@Service
public class CreateTicketServiceImpl implements CreateTicketService {

	@Autowired
	TicketRepository ticketTrackerRepository;
	
	@Override
	public Object createTicket(Ticket ticket) {
		return ticketTrackerRepository.save(ticket);
	}
}

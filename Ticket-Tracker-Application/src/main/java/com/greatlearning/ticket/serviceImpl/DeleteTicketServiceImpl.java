package com.greatlearning.ticket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.repository.TicketRepository;
import com.greatlearning.ticket.service.DeleteTicketService;

@Service
public class DeleteTicketServiceImpl implements DeleteTicketService{

	@Autowired
	TicketRepository ticketTrackerRepository;
	
	@Override
	public void deleteTicketById(long id) {
		ticketTrackerRepository.deleteById(id);
	}
}

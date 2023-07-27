package com.greatlearning.ticket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.repository.TicketRepository;
import com.greatlearning.ticket.service.ReadTicketService;

@Service
public class ReadTicketServiceImpl implements ReadTicketService {

	@Autowired
	TicketRepository ticketTrackerRepository;

	public List<Ticket> getListOfTickets() {
		return ticketTrackerRepository.findAll();
	}

	@Override
	public Ticket getTicketById(long id) {
		return ticketTrackerRepository.findById(id).get();
	}

	@Override
	public List<Ticket> searchByKeyword(String keyword) {
		return ticketTrackerRepository.searchByKeyword(keyword);
	}

}

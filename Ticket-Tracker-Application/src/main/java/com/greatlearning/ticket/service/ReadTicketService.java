package com.greatlearning.ticket.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.ticket.entity.Ticket;

public interface ReadTicketService {

	public List<Ticket> getListOfTickets();

	public Ticket getTicketById(long id);

	public List<Ticket> searchByKeyword(String keyword);
}

package com.greatlearning.ticket.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticket.entity.Ticket;
import com.greatlearning.ticket.service.CreateTicketService;
import com.greatlearning.ticket.service.DeleteTicketService;
import com.greatlearning.ticket.service.EditTicketService;
import com.greatlearning.ticket.service.ReadTicketService;

@Controller
@RequestMapping("/ticket")
public class TicketTrackerController {

	@Autowired
	ReadTicketService readTicketService;

	@Autowired
	CreateTicketService createTicketService;

	@Autowired
	EditTicketService editTicketService;

	@Autowired
	DeleteTicketService deleteTicketService;

	// Get Tickets List, Ticket By Id, View Ticket, Search Ticket...
	@GetMapping("/allTickets")
	public List<Ticket> getListOfTickets() {

		return readTicketService.getListOfTickets();
	}

	@GetMapping("/ticketById")
	public Object getTicketById(long id) {
		return readTicketService.getTicketById(id);
	}

	@GetMapping("/ticketsList")
	public String ticketsList(Model model) {
		List<Ticket> listOfTickets = readTicketService.getListOfTickets();
		model.addAttribute("tickets", listOfTickets);
		return "tickets/tickets-list";
	}

	@GetMapping("/viewTicket/{id}")
	public String viewTicket(@RequestParam("Id") long id, Model model) {

		Ticket ticket = readTicketService.getTicketById(id);
		model.addAttribute("tickets", ticket);
		return "tickets/view-ticket";
	}

	@GetMapping("/search")
	public String searchTicket(@RequestParam("keyword") String keyword, Model model) {
		List<Ticket> tickets = readTicketService.searchByKeyword(keyword);
		model.addAttribute("tickets", tickets);
		return "tickets/tickets-list";
	}

	// Create Ticket, Save Ticket
	@PostMapping("/createTicket")
	public Object createTicket(@RequestParam("Id") long id, @RequestParam("TicketTitle") String ticketTitle,
			@RequestParam("TicketDescription") String ticketDescription, @RequestParam("Content") String content,
			@RequestParam("Date") LocalDate date) {
		Ticket ticket = new Ticket();
		ticket.setId(id);
		ticket.setTicketTitle(ticketTitle);
		ticket.setTicketDescription(ticketDescription);
		ticket.setContent(content);
		ticket.setDate(date);
		return createTicketService.createTicket(ticket);
	}

	@GetMapping("/showFormForNewTicket")
	public String showFormForNewTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("tickets", ticket);
		return "tickets/new-ticket";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("tickets") Ticket ticket) {
		createTicketService.createTicket(ticket);
		return "redirect:/ticket/ticketsList";
	}

	// Edit Ticket
	@PutMapping("/editTicket")
	public Object editTicket(@RequestParam("Id") long id, @RequestBody Ticket ticket) {
		return editTicketService.editTicket(id, ticket);
	}

	@GetMapping("/showFormForEdit/{id}")
	public String showFormForEdit(@RequestParam("Id") long id, Model model) {
		Ticket ticket = readTicketService.getTicketById(id);
		model.addAttribute("tickets", ticket);
		return "tickets/edit-ticket";
	}

	// Delete Ticket
	@DeleteMapping("/deleteTicketById")
	public void deleteTicketById(@RequestParam("Id") long id) {
		deleteTicketService.deleteTicketById(id);
	}

	@GetMapping("/delete/{id}")
	public String deleteATicket(@RequestParam("Id") long id) {
		deleteTicketService.deleteTicketById(id);
		return "redirect:/ticket/ticketsList";
	}
}

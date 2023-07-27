package com.greatlearning.ticket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "Ticket_Title")
	private String ticketTitle;
	
	@Column(name= "Ticket_Description")
	private String ticketDescription;
	
	@Column(name= "Content")
	private String content;
	
	@Column(name= "Date")
	private LocalDate date= LocalDate.now();
}

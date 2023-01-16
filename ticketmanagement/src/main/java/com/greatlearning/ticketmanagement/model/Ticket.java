package com.greatlearning.ticketmanagement.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	public int id;
	@Column(name = "ticket_created_on")
	public Date ticketCreatedOn;
	@Column(name = "ticket_name")
	public String ticketName;
	@Column(name = "ticket_short_desc")
	public String ticketShortDescription;
	@Column(name = "ticket_description") 
	private String ticketDescription;
	
	
	public String getticketName() { 
		return ticketName; 
		}
	public String getTicketShortDescription() { 
		return ticketShortDescription; 
		}
	public String getTicketDescription() { 
		return ticketDescription; 
		}
	public Date getTicketCreatedOn() { 
		return ticketCreatedOn; 
		}
	public Integer getid() { 
		return id; 
		}
	public String setticketName( String ticketName) { 
		return this.ticketName =  ticketName; 
		}
	public String setticketShortDescription(String ticketShortDescription) { 
		return this.ticketShortDescription = ticketShortDescription; 
		}
	public String setticketDescription(String ticketDescription) { 
		return this.ticketDescription = ticketDescription; 
		}
	public Date setticketCreatedOn(Date ticketCreatedOn) { 
		return this.ticketCreatedOn = new Date(); 
		}
	public Integer setid(Integer id) { 
		return this.id =  id; 
		}

}
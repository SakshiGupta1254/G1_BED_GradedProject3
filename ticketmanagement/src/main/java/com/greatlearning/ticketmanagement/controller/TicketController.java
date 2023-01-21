package com.greatlearning.ticketmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.ticketmanagement.model.Ticket;
import com.greatlearning.ticketmanagement.service.TicketService;



@Controller
public class TicketController {
	@Autowired
	TicketService service;
	/*
	 * /employees  GET
	 * /employees/new
	 * /employees/edit{id}
	 * /employees/delete{id}
	 *  /employees  POST
	 */
	
	@GetMapping("/admin/tickets")
	public String getAllTickets(Model model) {
		List<Ticket> result = service.getAllTickets();
		model.addAttribute("tickets", result);
		return "tickets";
	}
	
	@GetMapping("/admin/tickets/newTicket")
	public String addNewTicket(Model model) {
		Ticket result = new Ticket();
		model.addAttribute("ticket", result);
		return "create_ticket";
	}
	
	@GetMapping("/admin/tickets/edit/{id}")
	public String UpdateTicket(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "edit_ticket";
	}
	@GetMapping("/admin/tickets/view/{id}")
	public String ViewTicket(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "view_ticket";
	}
	
	@GetMapping("/admin/tickets/delete/{id}")
	public String deleteTicket(Model model, @PathVariable("id") int id) {
		service.deleteTicketById(id);
		return "redirect:/admin/tickets";
	}

	@PostMapping("/admin/tickets")
	public String saveNewTicket(@ModelAttribute("tickets") Ticket ticket) {
		ticket.setticketCreatedOn( new Date());
		service.saveOrUpdate(ticket);
		return "redirect:/admin/tickets";
	}
	
	@PostMapping("/admin/tickets/{id}")
	public String updateEmployee(@ModelAttribute("ticket") Ticket ticket,@PathVariable("id") int id) {
		Ticket existingticket = service.getTicketById(id);
		existingticket.setticketName(ticket.getticketName());
		existingticket.setticketShortDescription(ticket.getTicketShortDescription());
		existingticket.setticketDescription(ticket.getTicketDescription());
		service.saveOrUpdate(existingticket);
		
		return "redirect:/admin/tickets";
	}
	@GetMapping("/admin/tickets/search")
	public String searchTickets(Model model, String query) {
		if(query != null) {
			   List<Ticket> result = service.getByKeyword(query);
			   model.addAttribute("tickets",result);
		}
		 return "tickets";
	}
	

}

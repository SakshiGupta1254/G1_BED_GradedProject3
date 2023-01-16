package com.greatlearning.ticketmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.greatlearning.ticketmanagement.model.Ticket;
import com.greatlearning.ticketmanagement.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository repository;
	
	@Override
	public List<Ticket> getAllTickets() {
		return repository.findAll();
	}
	
	@Override
	public void saveOrUpdate(Ticket emp) {
		repository.save(emp);
		
	}
	@Override
	public void deleteTicketById(int id) {
		repository.deleteById(id);
		
	}
	@Override
	public Ticket getTicketById(int id) {
		return repository.findById(id).get();
		
	}

	@Override
	public List<Ticket> getByKeyword(String query) {
		    return repository.findBy(query);
	}


}

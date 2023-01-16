package com.greatlearning.ticketmanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.ticketmanagement.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	 @Query("select s from Ticket s where s.ticketName=sakshi" )
	
	 public List<Ticket> findBy(String query);

}

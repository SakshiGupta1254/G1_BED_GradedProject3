package com.greatlearning.ticketmanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.ticketmanagement.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	 @Query(value = "SELECT * FROM tickets t WHERE " +
	            "LOWER(t.ticket_name) LIKE LOWER(CONCAT('%',:query, '%')) OR " +
	            "LOWER(t.ticket_short_desc) LIKE LOWER(CONCAT('%',:query, '%'))",
	            nativeQuery = true
	    )
	
	 List<Ticket> getByKeyword(@Param("query") String query);

}

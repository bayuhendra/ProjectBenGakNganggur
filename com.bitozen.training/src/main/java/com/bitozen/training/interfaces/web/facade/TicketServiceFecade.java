package com.bitozen.training.interfaces.web.facade;

import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ASUS
 */
public interface TicketServiceFecade {

    ResponseEntity<Void> submitTicket(TicketDTO ticketDTO);

    ResponseEntity<Void> deleteTicket(TicketDTO ticketDTO);

    ResponseEntity<TicketDTO> findByID(String ticketID);

    ResponseEntity<List<TicketDTO>> findAll();

    ResponseEntity<List<TicketDTO>> findByParams(Map map);

}

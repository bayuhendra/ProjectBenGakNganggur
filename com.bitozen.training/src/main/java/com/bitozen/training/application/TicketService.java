package com.bitozen.training.application;

import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface TicketService {

    void saveTicket(TicketDTO ticket);

    void deleteTicket(TicketDTO ticket);

    TicketDTO getDummy();

    TicketDTO findByID(String ticketID);

    List<TicketDTO> findAll();

    List<TicketDTO> findByParams(Map map);

}

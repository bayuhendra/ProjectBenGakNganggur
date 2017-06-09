package com.bitozen.training.domain.model.ticket;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface TicketRepository {

    void saveOrUpdate(Ticket ticket);

    void deleteData(Ticket ticket);

    Ticket findByID(String ticketID);

    List<Ticket> findAll();

    List<Ticket> findByParams(Map map);

}

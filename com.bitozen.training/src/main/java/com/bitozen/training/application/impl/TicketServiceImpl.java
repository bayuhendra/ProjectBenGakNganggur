package com.bitozen.training.application.impl;

import com.bitozen.training.application.TicketService;
import com.bitozen.training.common.type.Priority;
import com.bitozen.training.common.status.StatusTicket;
import com.bitozen.training.domain.model.ticket.Ticket;
import com.bitozen.training.domain.model.ticket.TicketBuilder;
import com.bitozen.training.domain.model.ticket.TicketRepository;
import com.bitozen.training.common.type.TypeTicket;
import com.bitozen.training.interfaces.web.facade.dto.assembler.ticket.TicketDTOAssembler;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;

/**
 *
 * @author ASUS
 */
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private TicketDTOAssembler ticketDTOAssembler;

    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void setTicketDTOAssembler(TicketDTOAssembler ticketDTOAssembler) {
        this.ticketDTOAssembler = ticketDTOAssembler;
    }

    @Override
    public void saveTicket(TicketDTO ticket) {
        Validate.notNull(ticketRepository);
        Ticket t = ticketRepository.findByID(ticket.getTicketID());

        if (t == null) {
            t = ticketDTOAssembler.toDomain(ticket);
        } else {
            Ticket newTicket = ticketDTOAssembler.toDomain(ticket);
            t.assignNewTicket(newTicket);

        }
        ticketRepository.saveOrUpdate(t);
    }

    @Override
    public TicketDTO getDummy() {
        Ticket ticket = new TicketBuilder()
                .setTicketID("TICKET001")
                .setUserID("USER001")
                .setTypeTicket(TypeTicket.INCIDENT)
                .setTittleTicket("Server Down")
                .setTicketDescription("Server down tiap pagi down")
                .setAttachmentDocument("serverdown.jpg")
                .setStatusTicket(StatusTicket.OPEN)
                .setPriority(Priority.HIGH)
                .setAgeTicket("2 minggu")
                .setTimeToResolved("Tidak di tentukan")
                .setCreatedDate(new Date())
                .setCreatedBy("Bayu Hendra Setiawan")
                .setModifiedDate(new Date())
                .setModifiedBy("Wiwit Setyo Putro")
                .createTicket();
        return ticketDTOAssembler.toDTO(ticket);
    }

    @Override
    public TicketDTO findByID(String ticketID) {
        Validate.notNull(ticketRepository);
        Ticket t = (Ticket) ticketRepository.findByID(ticketID);
        if (t != null) {
            return ticketDTOAssembler.toDTO(t);
        }
        return null;
    }

    @Override
    public List<TicketDTO> findAll() {
        Validate.notNull(ticketRepository);
        return (List<TicketDTO>) ticketDTOAssembler.toDTO((List<Ticket>) ticketRepository.findAll());
    }

    @Override
    public void deleteTicket(TicketDTO ticket) {
        Ticket t = ticketDTOAssembler.toDomain(ticket);
        ticketRepository.deleteData(t);
    }

    @Override
    public List<TicketDTO> findByParams(Map map) {
        Validate.notNull(ticketRepository);
        List<Ticket> listTicket = ticketRepository.findByParams(map);
        if (listTicket != null) {
            return (List<TicketDTO>) ticketDTOAssembler.toDTO(listTicket);
        }
        return null;
    }

}

package com.bitozen.training.interfaces.web.facade.dto.assembler.ticket;

import com.bitozen.training.domain.model.ticket.Ticket;
import com.bitozen.training.domain.model.ticket.TicketBuilder;
import com.bitozen.training.interfaces.web.facade.dto.assembler.IObjectAssembler;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTOBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TicketDTOAssembler implements IObjectAssembler<Ticket, TicketDTO> {

    @Override
    public TicketDTO toDTO(Ticket domainObject) {
        return new TicketDTOBuilder()
                .setTicketID(domainObject.getTicketID())
                .setUserID(domainObject.getUserID())
                .setTypeTicket(domainObject.getTypeTicket())
                .setTittleTicket(domainObject.getTittleTicket())
                .setTicketDescription(domainObject.getTicketDescription())
                .setAttachmentDocument(domainObject.getAttachmentDocument())
                .setStatusTicket(domainObject.getStatusTicket())
                .setPriority(domainObject.getPriority())
                .setAgeTicket(domainObject.getAgeTicket())
                .setTimeToResolved(domainObject.getTimeToResolved())
                .setCreatedDate(domainObject.getCreatedDate())
                .setCreatedBy(domainObject.getCreatedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .createTicketDTO();

    }

    @Override
    public Ticket toDomain(TicketDTO dtoObject) {
        return new TicketBuilder()
                .setTicketID(dtoObject.getTicketID())
                .setUserID(dtoObject.getUserID())
                .setTypeTicket(dtoObject.getTypeTicket())
                .setTittleTicket(dtoObject.getTittleTicket())
                .setTicketDescription(dtoObject.getTicketDescription())
                .setAttachmentDocument(dtoObject.getAttachmentDocument())
                .setStatusTicket(dtoObject.getStatusTicket())
                .setPriority(dtoObject.getPriority())
                .setAgeTicket(dtoObject.getAgeTicket())
                .setTimeToResolved(dtoObject.getTimeToResolved())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .createTicket();
    }

    public List<Ticket> toDomain(List<TicketDTO> arg0) {
        List<Ticket> res = new ArrayList<>();
        for (TicketDTO t : arg0) {
            res.add(new TicketDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<TicketDTO> toDTO(List<Ticket> arg0) {
        List<TicketDTO> res = new ArrayList<>();
        for (Ticket t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }
}

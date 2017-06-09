package com.bitozen.training.interfaces.web.facade.dto.ticket;

import com.bitozen.training.common.status.StatusTicket;
import com.bitozen.training.common.type.Priority;
import com.bitozen.training.common.type.TypeTicket;
import java.util.Date;


public class TicketDTOBuilder {
    private String ticketID;
    private String userID;
    private TypeTicket typeTicket;
    private String tittleTicket;
    private String ticketDescription;
    private String attachmentDocument;
    private StatusTicket statusTicket;
    private Priority priority;
    private String ageTicket;
    private String timeToResolved;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;

    public TicketDTOBuilder() {
    }

    public TicketDTOBuilder setTicketID(String ticketID) {
        this.ticketID = ticketID;
        return this;
    }

    public TicketDTOBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public TicketDTOBuilder setTypeTicket(TypeTicket typeTicket) {
        this.typeTicket = typeTicket;
        return this;
    }

    public TicketDTOBuilder setTittleTicket(String tittleTicket) {
        this.tittleTicket = tittleTicket;
        return this;
    }

    public TicketDTOBuilder setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
        return this;
    }

    public TicketDTOBuilder setAttachmentDocument(String attachmentDocument) {
        this.attachmentDocument = attachmentDocument;
        return this;
    }

    public TicketDTOBuilder setStatusTicket(StatusTicket statusTicket) {
        this.statusTicket = statusTicket;
        return this;
    }

    public TicketDTOBuilder setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public TicketDTOBuilder setAgeTicket(String ageTicket) {
        this.ageTicket = ageTicket;
        return this;
    }

    public TicketDTOBuilder setTimeToResolved(String timeToResolved) {
        this.timeToResolved = timeToResolved;
        return this;
    }

    public TicketDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TicketDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TicketDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public TicketDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public TicketDTO createTicketDTO() {
        return new TicketDTO(ticketID, userID, typeTicket, tittleTicket, ticketDescription, attachmentDocument, statusTicket, priority, ageTicket, timeToResolved, createdDate, createdBy, modifiedDate, modifiedBy);
    }
    
}

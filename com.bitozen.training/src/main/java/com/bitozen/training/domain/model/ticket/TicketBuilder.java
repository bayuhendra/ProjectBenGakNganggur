package com.bitozen.training.domain.model.ticket;

import com.bitozen.training.common.status.StatusTicket;
import com.bitozen.training.common.type.Priority;
import com.bitozen.training.common.type.TypeTicket;
import java.util.Date;

public class TicketBuilder {

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

    public TicketBuilder() {
    }

    public TicketBuilder setTicketID(String ticketID) {
        this.ticketID = ticketID;
        return this;
    }

    public TicketBuilder setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public TicketBuilder setTypeTicket(TypeTicket typeTicket) {
        this.typeTicket = typeTicket;
        return this;
    }

    public TicketBuilder setTittleTicket(String tittleTicket) {
        this.tittleTicket = tittleTicket;
        return this;
    }

    public TicketBuilder setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
        return this;
    }

    public TicketBuilder setAttachmentDocument(String attachmentDocument) {
        this.attachmentDocument = attachmentDocument;
        return this;
    }

    public TicketBuilder setStatusTicket(StatusTicket statusTicket) {
        this.statusTicket = statusTicket;
        return this;
    }

    public TicketBuilder setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public TicketBuilder setAgeTicket(String ageTicket) {
        this.ageTicket = ageTicket;
        return this;
    }

    public TicketBuilder setTimeToResolved(String timeToResolved) {
        this.timeToResolved = timeToResolved;
        return this;
    }

    public TicketBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TicketBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TicketBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public TicketBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public Ticket createTicket() {
        return new Ticket(ticketID, userID, typeTicket, tittleTicket, ticketDescription, attachmentDocument, statusTicket, priority, ageTicket, timeToResolved, createdDate, createdBy, modifiedDate, modifiedBy);
    }

}

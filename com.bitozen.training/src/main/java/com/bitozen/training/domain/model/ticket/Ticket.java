package com.bitozen.training.domain.model.ticket;

import com.bitozen.training.common.type.Priority;
import com.bitozen.training.common.type.TypeTicket;
import com.bitozen.training.common.status.StatusTicket;
import com.bitozen.training.domain.shared.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Ticket implements EntityObject<Ticket> {

    long id;

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

    public Ticket() {
    }

    public Ticket(String ticketID, String userID, TypeTicket typeTicket, String tittleTicket, String ticketDescription, String attachmentDocument, StatusTicket statusTicket, Priority priority, String ageTicket, String timeToResolved, Date createdDate, String createdBy, Date modifiedDate, String modifiedBy) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.typeTicket = typeTicket;
        this.tittleTicket = tittleTicket;
        this.ticketDescription = ticketDescription;
        this.attachmentDocument = attachmentDocument;
        this.statusTicket = statusTicket;
        this.priority = priority;
        this.ageTicket = ageTicket;
        this.timeToResolved = timeToResolved;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getUserID() {
        return userID;
    }

    public TypeTicket getTypeTicket() {
        return typeTicket;
    }

    public String getTittleTicket() {
        return tittleTicket;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public String getAttachmentDocument() {
        return attachmentDocument;
    }

    public StatusTicket getStatusTicket() {
        return statusTicket;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAgeTicket() {
        return ageTicket;
    }

    public String getTimeToResolved() {
        return timeToResolved;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.ticketID);
        hash = 19 * hash + Objects.hashCode(this.userID);
        hash = 19 * hash + Objects.hashCode(this.typeTicket);
        hash = 19 * hash + Objects.hashCode(this.tittleTicket);
        hash = 19 * hash + Objects.hashCode(this.ticketDescription);
        hash = 19 * hash + Objects.hashCode(this.attachmentDocument);
        hash = 19 * hash + Objects.hashCode(this.statusTicket);
        hash = 19 * hash + Objects.hashCode(this.priority);
        hash = 19 * hash + Objects.hashCode(this.ageTicket);
        hash = 19 * hash + Objects.hashCode(this.timeToResolved);
        hash = 19 * hash + Objects.hashCode(this.createdDate);
        hash = 19 * hash + Objects.hashCode(this.createdBy);
        hash = 19 * hash + Objects.hashCode(this.modifiedDate);
        hash = 19 * hash + Objects.hashCode(this.modifiedBy);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void assignNewTicket(Ticket ticket) {
        this.ticketID = ticket.ticketID;
        this.userID = ticket.userID;
        this.typeTicket = ticket.typeTicket;
        this.tittleTicket = ticket.tittleTicket;
        this.ticketDescription = ticket.ticketDescription;
        this.attachmentDocument = ticket.attachmentDocument;
        this.statusTicket = ticket.statusTicket;
        this.priority = ticket.priority;
        this.ageTicket = ticket.ageTicket;
        this.timeToResolved = ticket.timeToResolved;
        this.modifiedDate = ticket.modifiedDate;
        this.modifiedBy = ticket.modifiedBy;
    }

    @Override
    public boolean sameIdentityAs(Ticket other) {
        return this.equals(other);
    }

}

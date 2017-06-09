package com.bitozen.training.interfaces.web.facade.dto.ticket;

import com.bitozen.training.common.type.Priority;
import com.bitozen.training.common.status.StatusTicket;
import com.bitozen.training.common.type.TypeTicket;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TicketDTO implements Serializable {

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

    public TicketDTO() {
    }

    public TicketDTO(String ticketID, String userID, TypeTicket typeTicket, String tittleTicket, String ticketDescription, String attachmentDocument, StatusTicket statusTicket, Priority priority, String ageTicket, String timeToResolved, Date createdDate, String createdBy, Date modifiedDate, String modifiedBy) {
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

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public TypeTicket getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(TypeTicket typeTicket) {
        this.typeTicket = typeTicket;
    }

    public String getTittleTicket() {
        return tittleTicket;
    }

    public void setTittleTicket(String tittleTicket) {
        this.tittleTicket = tittleTicket;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public String getAttachmentDocument() {
        return attachmentDocument;
    }

    public void setAttachmentDocument(String attachmentDocument) {
        this.attachmentDocument = attachmentDocument;
    }

    public StatusTicket getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(StatusTicket statusTicket) {
        this.statusTicket = statusTicket;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getAgeTicket() {
        return ageTicket;
    }

    public void setAgeTicket(String ageTicket) {
        this.ageTicket = ageTicket;
    }

    public String getTimeToResolved() {
        return timeToResolved;
    }

    public void setTimeToResolved(String timeToResolved) {
        this.timeToResolved = timeToResolved;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "TicketDTO{" + "ticketID=" + ticketID + ", userID=" + userID + ", typeTicket=" + typeTicket + ", tittleTicket=" + tittleTicket + ", ticketDescription=" + ticketDescription + ", attachmentDocument=" + attachmentDocument + ", statusTicket=" + statusTicket + ", priority=" + priority + ", ageTicket=" + ageTicket + ", timeToResolved=" + timeToResolved + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + '}';
    }

}

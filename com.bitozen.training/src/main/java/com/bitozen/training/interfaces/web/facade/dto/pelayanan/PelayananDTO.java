package com.bitozen.training.interfaces.web.facade.dto.pelayanan;

import com.bitozen.training.common.status.PelayananStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 10991001
 */
public class PelayananDTO implements Serializable {

    private String layananID;
    private String kelompokLayanan;
    private String namaLayanan;
    private String deskripsiLayanan;
    private Date startdate;
    private PelayananStatus status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PelayananDTO() {
    }

    public PelayananDTO(String layananID, String kelompokLayanan, String namaLayanan, String deskripsiLayanan, Date startdate, PelayananStatus status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.layananID = layananID;
        this.kelompokLayanan = kelompokLayanan;
        this.namaLayanan = namaLayanan;
        this.deskripsiLayanan = deskripsiLayanan;
        this.startdate = startdate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getLayananID() {
        return layananID;
    }

    public void setLayananID(String layananID) {
        this.layananID = layananID;
    }

    public String getKelompokLayanan() {
        return kelompokLayanan;
    }

    public void setKelompokLayanan(String kelompokLayanan) {
        this.kelompokLayanan = kelompokLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public String getDeskripsiLayanan() {
        return deskripsiLayanan;
    }

    public void setDeskripsiLayanan(String deskripsiLayanan) {
        this.deskripsiLayanan = deskripsiLayanan;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public PelayananStatus getStatus() {
        return status;
    }

    public void setStatus(PelayananStatus status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "PelayananDTO{" + "layananID=" + layananID + ", kelompokLayanan=" + kelompokLayanan + ", namaLayanan=" + namaLayanan + ", deskripsiLayanan=" + deskripsiLayanan + ", startdate=" + startdate + ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + '}';
    }

}

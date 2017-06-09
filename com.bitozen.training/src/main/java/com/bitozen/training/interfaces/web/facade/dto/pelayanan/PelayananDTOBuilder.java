package com.bitozen.training.interfaces.web.facade.dto.pelayanan;

import com.bitozen.training.common.status.PelayananStatus;
import java.util.Date;


public class PelayananDTOBuilder {
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

    public PelayananDTOBuilder() {
    }

    public PelayananDTOBuilder setLayananID(String layananID) {
        this.layananID = layananID;
        return this;
    }

    public PelayananDTOBuilder setKelompokLayanan(String kelompokLayanan) {
        this.kelompokLayanan = kelompokLayanan;
        return this;
    }

    public PelayananDTOBuilder setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
        return this;
    }

    public PelayananDTOBuilder setDeskripsiLayanan(String deskripsiLayanan) {
        this.deskripsiLayanan = deskripsiLayanan;
        return this;
    }

    public PelayananDTOBuilder setStartdate(Date startdate) {
        this.startdate = startdate;
        return this;
    }

    public PelayananDTOBuilder setStatus(PelayananStatus status) {
        this.status = status;
        return this;
    }

    public PelayananDTOBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PelayananDTOBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PelayananDTOBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PelayananDTOBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public PelayananDTO createPelayananDTO() {
        return new PelayananDTO(layananID, kelompokLayanan, namaLayanan, deskripsiLayanan, startdate, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}

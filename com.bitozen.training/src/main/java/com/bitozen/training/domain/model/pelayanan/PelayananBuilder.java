package com.bitozen.training.domain.model.pelayanan;

import com.bitozen.training.common.status.PelayananStatus;
import java.util.Date;


public class PelayananBuilder {
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

    public PelayananBuilder() {
    }

    public PelayananBuilder setLayananID(String layananID) {
        this.layananID = layananID;
        return this;
    }

    public PelayananBuilder setKelompokLayanan(String kelompokLayanan) {
        this.kelompokLayanan = kelompokLayanan;
        return this;
    }

    public PelayananBuilder setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
        return this;
    }

    public PelayananBuilder setDeskripsiLayanan(String deskripsiLayanan) {
        this.deskripsiLayanan = deskripsiLayanan;
        return this;
    }

    public PelayananBuilder setStartdate(Date startdate) {
        this.startdate = startdate;
        return this;
    }

    public PelayananBuilder setStatus(PelayananStatus status) {
        this.status = status;
        return this;
    }

    public PelayananBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public PelayananBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PelayananBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public PelayananBuilder setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Pelayanan createPelayanan() {
        return new Pelayanan(layananID, kelompokLayanan, namaLayanan, deskripsiLayanan, startdate, status, createdBy, createdDate, modifiedBy, modifiedDate);
    }
    
}

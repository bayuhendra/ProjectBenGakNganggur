package com.bitozen.training.domain.model.pelayanan;

import com.bitozen.training.common.status.PelayananStatus;
import com.bitozen.training.domain.shared.EntityObject;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 10991001
 */
public class Pelayanan implements EntityObject<Pelayanan>{
    long id;
    
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

    public Pelayanan() {
    }

    public Pelayanan(String layananID, String kelompokLayanan, String namaLayanan, String deskripsiLayanan, Date startdate, PelayananStatus status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
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

    public String getKelompokLayanan() {
        return kelompokLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public String getDeskripsiLayanan() {
        return deskripsiLayanan;
    }

    public Date getStartdate() {
        return startdate;
    }

    public PelayananStatus getStatus() {
        return status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.layananID);
        hash = 59 * hash + Objects.hashCode(this.kelompokLayanan);
        hash = 59 * hash + Objects.hashCode(this.namaLayanan);
        hash = 59 * hash + Objects.hashCode(this.deskripsiLayanan);
        hash = 59 * hash + Objects.hashCode(this.startdate);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.createdBy);
        hash = 59 * hash + Objects.hashCode(this.createdDate);
        hash = 59 * hash + Objects.hashCode(this.modifiedBy);
        hash = 59 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }
    
    public void assignNewPelayanan(Pelayanan pelayanan){
        this.layananID = pelayanan.layananID;
        this.kelompokLayanan = pelayanan.kelompokLayanan;
        this.namaLayanan = pelayanan.namaLayanan;
        this.deskripsiLayanan = pelayanan.deskripsiLayanan;
        this.startdate = pelayanan.startdate;
        this.modifiedBy = pelayanan.modifiedBy;
        this.modifiedDate = pelayanan.modifiedDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelayanan other = (Pelayanan) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public boolean sameIdentityAs(Pelayanan other) {
        return this.equals(other);
    }
    
}

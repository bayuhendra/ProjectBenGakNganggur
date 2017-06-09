package com.bitozen.training.interfaces.web.facade.dto.assembler.pelayanan;

import com.bitozen.training.domain.model.pelayanan.Pelayanan;
import com.bitozen.training.domain.model.pelayanan.PelayananBuilder;
import com.bitozen.training.interfaces.web.facade.dto.assembler.IObjectAssembler;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTOBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10991001
 */
public class PelayananDTOAssembler implements IObjectAssembler<Pelayanan, PelayananDTO> {

    @Override
    public PelayananDTO toDTO(Pelayanan domainObject) {
        return new PelayananDTOBuilder()
                .setLayananID(domainObject.getLayananID())
                .setNamaLayanan(domainObject.getNamaLayanan())
                .setKelompokLayanan(domainObject.getKelompokLayanan())
                .setDeskripsiLayanan(domainObject.getDeskripsiLayanan())
                .setStartdate(domainObject.getStartdate())
                .setStatus(domainObject.getStatus())
                .setCreatedBy(domainObject.getCreatedBy())
                .setCreatedDate(domainObject.getCreatedDate())
                .setModifiedBy(domainObject.getModifiedBy())
                .setModifiedDate(domainObject.getModifiedDate())
                .createPelayananDTO();
    }

    @Override
    public Pelayanan toDomain(PelayananDTO dtoObject) {
        return new PelayananBuilder()
                .setLayananID(dtoObject.getLayananID())
                .setNamaLayanan(dtoObject.getNamaLayanan())
                .setKelompokLayanan(dtoObject.getKelompokLayanan())
                .setDeskripsiLayanan(dtoObject.getDeskripsiLayanan())
                .setStartdate(dtoObject.getStartdate())
                .setStatus(dtoObject.getStatus())
                .setCreatedBy(dtoObject.getCreatedBy())
                .setCreatedDate(dtoObject.getCreatedDate())
                .setModifiedBy(dtoObject.getModifiedBy())
                .setModifiedDate(dtoObject.getModifiedDate())
                .createPelayanan();
    }

    public List<Pelayanan> toDomain(List<PelayananDTO> arg0) {
        List<Pelayanan> res = new ArrayList<>();
        for (PelayananDTO t : arg0) {
            res.add(new PelayananDTOAssembler().toDomain(t));
        }
        return res;
    }

    public List<PelayananDTO> toDTO(List<Pelayanan> arg0) {
        List<PelayananDTO> res = new ArrayList<>();
        for (Pelayanan t : arg0) {
            res.add(this.toDTO(t));
        }
        return res;
    }

}

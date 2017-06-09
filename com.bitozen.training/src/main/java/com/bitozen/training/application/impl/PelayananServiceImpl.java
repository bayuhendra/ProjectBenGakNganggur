package com.bitozen.training.application.impl;

import com.bitozen.training.application.PelayananService;
import com.bitozen.training.common.status.PelayananStatus;
import com.bitozen.training.domain.model.pelayanan.Pelayanan;
import com.bitozen.training.domain.model.pelayanan.PelayananBuilder;
import com.bitozen.training.domain.model.pelayanan.PelayananRepository;
import com.bitozen.training.interfaces.web.facade.dto.assembler.pelayanan.PelayananDTOAssembler;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang.Validate;

/**
 *
 * @author 10991001
 */
public class PelayananServiceImpl implements PelayananService {

    private PelayananRepository pelayananRepository;
    private PelayananDTOAssembler pelayananDTOAssembler;

    public void setPelayananRepository(PelayananRepository pelayananRepository) {
        this.pelayananRepository = pelayananRepository;
    }

    public void setPelayananDTOAssembler(PelayananDTOAssembler pelayananDTOAssembler) {
        this.pelayananDTOAssembler = pelayananDTOAssembler;
    }

    @Override
    public void SaveOrUpdate(PelayananDTO pelayanan) {
        Validate.notNull(pelayananRepository);
        Pelayanan p = pelayananRepository.findByID(pelayanan.getLayananID());

        if (p == null) {
            p = pelayananDTOAssembler.toDomain(pelayanan);
        } else {
            Pelayanan newPelayanan = pelayananDTOAssembler.toDomain(pelayanan);
            p.assignNewPelayanan(newPelayanan);

        }
        pelayananRepository.SaveOrUpdate(p);
    }

    @Override
    public void deleteData(PelayananDTO pelayanan) {
        Pelayanan p = pelayananDTOAssembler.toDomain(pelayanan);
        pelayananRepository.deleteData(p);
    }

    @Override
    public PelayananDTO findByID(String pelayananID) {
        Validate.notNull(pelayananRepository);
        Pelayanan p = (Pelayanan) pelayananRepository.findByID(pelayananID);
        if (p != null) {
            return pelayananDTOAssembler.toDTO(p);
        }
        return null;
    }

    @Override
    public List<PelayananDTO> findAll() {
        Validate.notNull(pelayananRepository);
        return (List<PelayananDTO>) pelayananDTOAssembler.toDTO((List<Pelayanan>) pelayananRepository.findAll());
    }

    @Override
    public List<PelayananDTO> findByParams(Map map) {
        Validate.notNull(pelayananRepository);
        List<Pelayanan> listPelayanan = pelayananRepository.findByParams(map);
        if (listPelayanan != null) {
            return (List<PelayananDTO>) pelayananDTOAssembler.toDTO(listPelayanan);
        }
        return null;
    }

    @Override
    public PelayananDTO getDummyData() {
        Pelayanan p = new PelayananBuilder()
                .setLayananID(UUID.randomUUID().toString())
                .setKelompokLayanan("APLIKASI")
                .setNamaLayanan("Pembuatan Aplikasi")
                .setDeskripsiLayanan("Deskripsi Pembuatan Aplikasi")
                .setStartdate(new Date())
                .setStatus(PelayananStatus.ACTIVE)
                .setCreatedBy("ADMIN")
                .setCreatedDate(new Date())
                .setModifiedBy("ADMIN")
                .setModifiedDate(new Date())
                .createPelayanan();

        return pelayananDTOAssembler.toDTO(p);
    }
}

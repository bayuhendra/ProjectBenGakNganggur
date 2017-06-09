package com.bitozen.training.interfaces.web.rest;

import com.bitozen.training.application.PelayananService;
import com.bitozen.training.interfaces.web.facade.PelayananServiceFacade;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 10991001
 */
@Controller
public class PelayananServiceRestImpl implements PelayananServiceFacade {

    @Autowired
    private PelayananService pelayananService;

    @Override
    @RequestMapping(value = "/bitozen.service.pelayanan", method = RequestMethod.POST)
    public ResponseEntity<Void> SaveOrUpdate(@RequestBody PelayananDTO pelayanan) {
        Validate.notNull(pelayananService);
        pelayananService.SaveOrUpdate(pelayanan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.pelayanan.delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteData(@RequestBody PelayananDTO pelayanan) {
        pelayananService.deleteData(pelayanan);
        return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.pelayanan.getDummy", method = RequestMethod.GET)
    public ResponseEntity<PelayananDTO> getDummyData() {
        return new ResponseEntity<>(pelayananService.getDummyData(), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.pelayanan.get/{pelayananID}", method = RequestMethod.GET)
    public ResponseEntity<PelayananDTO> findByID(@PathVariable("pelayananID") String pelayananID) {
        PelayananDTO pelayananDTO = pelayananService.findByID(pelayananID);
        if (pelayananDTO != null) {
            return new ResponseEntity<>((pelayananDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/bitozen.service.pelayanan.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<PelayananDTO>> findAll() {
        return new ResponseEntity<>((pelayananService.findAll()), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.pelayanan.get.params/{namaLayanan}", method = RequestMethod.GET)
    public ResponseEntity<List<PelayananDTO>> findByParams(Map map) {
        return new ResponseEntity<>((pelayananService.findByParams(map)), HttpStatus.FOUND);
    }

}

package com.bitozen.training.interfaces.web.facade;

import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author 10991001
 */
public interface PelayananServiceFacade {

    ResponseEntity<Void> SaveOrUpdate(PelayananDTO pelayanan);

    ResponseEntity<Void> deleteData(PelayananDTO pelayanan);

    ResponseEntity<PelayananDTO> getDummyData();

    ResponseEntity<PelayananDTO> findByID(String pelayananID);

    ResponseEntity<List<PelayananDTO>> findAll();

    ResponseEntity<List<PelayananDTO>> findByParams(Map map);

}

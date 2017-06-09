package com.bitozen.training.application;

import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 10991001
 */
public interface PelayananService {

    void SaveOrUpdate(PelayananDTO pelayanan);

    void deleteData(PelayananDTO pelayanan);
    
    PelayananDTO getDummyData();

    PelayananDTO findByID(String pelayananID);

    List<PelayananDTO> findAll();

    List<PelayananDTO> findByParams(Map map);

}

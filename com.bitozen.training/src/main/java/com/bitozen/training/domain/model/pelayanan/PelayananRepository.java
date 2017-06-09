package com.bitozen.training.domain.model.pelayanan;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 10991001
 */
public interface PelayananRepository {

    void SaveOrUpdate(Pelayanan pelayanan);

    void deleteData(Pelayanan pelayanan);

    Pelayanan findByID(String pelayananID);

    List<Pelayanan> findAll();

    List<Pelayanan> findByParams(Map map);

}

package com.bitozen.training.domain.model.pelayanan;

import com.bitozen.training.application.PelayananService;
import com.bitozen.training.common.status.PelayananStatus;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author brian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/bitozen-context-application.xml",
    "classpath:/bitozen-context-infrastructure.xml"})
public class PelayananTest {

    @Autowired
    PelayananRepository pelayananRepository;

    @Autowired
    PelayananService pelayananService;

    public PelayananTest() {
    }

    /**
     * Test of Pelayanan Module.
     */
    @Test
    public void testPelayananService() {
        Validate.notNull(pelayananRepository);

        print("Start Pelayanan Processing");
        /* Start Pelayanan Processing */

        System.out.println("");
        print("Get Dummy Data Pelayanan");
        PelayananDTO pelayanan = pelayananService.getDummyData();
        System.out.println("Pelayanan :" + pelayanan.toString());

        System.out.println("");
        print("Save Data Pelayanan");
        pelayananService.SaveOrUpdate(pelayanan);
        System.out.println("Pelayanan has been saved succesfully");

        System.out.println("");
        print("Find Pelayanan by ID");
        PelayananDTO p = pelayananService.findByID(pelayanan.getLayananID());
        System.out.println("Pelayanan :" + p.toString());

        System.out.println("");
        print("Find All Pelayanan");
        List<PelayananDTO> listPelayanan = pelayananService.findAll();
        for (PelayananDTO layanan : listPelayanan) {
            System.out.println("Pelayanan :" + layanan.toString());
        }

        System.out.println("");
        print("Find Pelayanan by Params");
        Map map = new HashMap();
        map.put("status", PelayananStatus.ACTIVE);
        List<PelayananDTO> listPelayananParams = pelayananService.findByParams(map);
        for (PelayananDTO pl : listPelayananParams) {
            System.out.println("Pelayanan :" + pl.toString());
        }

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }

}

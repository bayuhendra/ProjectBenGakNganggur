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
 * @author 10991001
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/bitozen-context-application.xml",
    "classpath:/bitozen-context-infrastructure.xml"})
public class PelayananServiceTest {

    @Autowired
    private PelayananRepository pelayananRepository;

    @Autowired
    private PelayananService pelayananService;

    /**
     * Test of getLayananID method, of class Pelayanan.
     */
    @Test
    public void testEnd2EndPelayanan() {
        Validate.notNull(pelayananRepository);

        /* step 1 - get data dummy pelayanan */
        printThisMessage("Step 1 - Get Data Dummy");
        PelayananDTO p = pelayananService.getDummyData();
        System.out.println("Data Pelayanan" + p.toString());

        /* step 2 - store data pelayanan */
        printThisMessage("Step 2 - Store Data to DB");
        pelayananService.SaveOrUpdate(p);
        System.out.println("Data berhasil disimpan");

        /* step 3 - get Data Pelayanan by ID */
        printThisMessage("Step 3 - Get Data by ID");
        PelayananDTO pelayananByID = pelayananService.findByID(p.getLayananID());
        System.out.println("Data Pelayanan by ID " + pelayananByID);

        /* step 4 - get All Data Pelayanan */
        printThisMessage("Step 4 - Get All Data Pelayanan");
        List<PelayananDTO> listPelayanan = pelayananService.findAll();
        for (PelayananDTO pp : listPelayanan) {
            System.out.println("Data Semua Pelayanan" + pp.toString());
        }

        /* step 5 - get data pelayanan by Params*/
        printThisMessage("Step 5 - Get Data Pelayanan by Params");
        Map paramater = new HashMap();
        paramater.put("status", PelayananStatus.ACTIVE);

        List<PelayananDTO> listPelayananByParams = pelayananService.findByParams(paramater);
        for (PelayananDTO ppp : listPelayananByParams) {
            System.out.println("Data Pelayanan by Paramater" + ppp.toString());
        }

    }

    public void printThisMessage(String msg) {
        
        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }

}

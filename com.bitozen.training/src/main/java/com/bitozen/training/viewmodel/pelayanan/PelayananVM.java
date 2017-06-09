/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitozen.training.viewmodel.pelayanan;

import com.bitozen.training.application.PelayananService;
import com.bitozen.training.common.status.PelayananStatus;
import com.bitozen.training.common.zul.CommonViewModel;
import static com.bitozen.training.common.zul.CommonViewModel.showInformationMessagebox;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTO;
import com.bitozen.training.interfaces.web.facade.dto.pelayanan.PelayananDTOBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author ASUS
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PelayananVM {

    @WireVariable
    private PelayananService pelayananService;

    //Objek yang akan di binding
    private PelayananDTO pelayananDTO = new PelayananDTO();
    private List<PelayananDTO> pelayananDTOs = new ArrayList<>();

    //Add list for combobox
    private ListModelList<String> listKelompokLayanan = new ListModelList<>();
    private ListModelList<PelayananStatus> listStatusPelayanan = new ListModelList<>();

    //Atribut for searching
    private String layananID;
    private String namaLayanan;
    private PelayananStatus status;

    @Init
    public void init(
            @ExecutionArgParam("pelayananDTO") PelayananDTO pelayanan) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(pelayanan);

    }

    private void initData() {
        /* get all pelayanan */
        pelayananDTOs = pelayananService.findAll();

    }

    private void checkValidity(PelayananDTO pelayanan) {
        if (pelayanan == null) {
            pelayananDTO = new PelayananDTOBuilder()
                    .setCreatedBy("administrator")
                    .setCreatedDate(new Date())
                    .createPelayananDTO();
        } else {
            this.pelayananDTO = pelayanan;
            layananID = pelayananDTO.getLayananID();
            namaLayanan = pelayananDTO.getNamaLayanan();
            status = pelayanan.getStatus();
        }
    }

    @Command("buttonSavePelayanan")
    @NotifyChange({"pelayananDTO"})
    public void buttonSavePelayanan(@BindingParam("object") PelayananDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        pelayananService.SaveOrUpdate(pelayananDTO);
        showInformationMessagebox("Pelayanan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();

    }

    @Command("buttonCreateLayanan")
    @NotifyChange("layananDTO")
    public void buttonCreateLayanan(@BindingParam("object") PelayananDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("pelayananDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/Layout/Create_Layanan.zul", window, params);
    }

    @Command("buttonCancel")
    @NotifyChange("pelayananDTO")
    public void buttonCancel(@BindingParam("object") PelayananDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonPencarian")
    @NotifyChange("pelayananDTOs")
    public void buttonPencarian(@ContextParam(ContextType.VIEW) Window window) {

        Map params = new HashMap();
        params.put("layananID", layananID);
        params.put("namaLayanan", namaLayanan);
        params.put("status", status);

        pelayananDTOs = pelayananService.findByParams(params);
    }

    @Command("detailLayanan")
    @NotifyChange("pelayananDTO")
    public void detailLayanan(@BindingParam("object") PelayananDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("pelayananDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/Layout/Create_Layanan.zul", window, params);
    }

    @Command("deleteLayanan")
    @NotifyChange("pelayananDTOs")
    public void deleteTicket(@BindingParam("object") PelayananDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        pelayananDTO = (PelayananDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus layanan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    pelayananService.deleteData(pelayananDTO);
                    showInformationMessagebox("Pelayanan Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshData", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    @GlobalCommand
    @NotifyChange("pelayananDTOs")
    public void refreshData() {
        pelayananDTOs = pelayananService.findAll();
    }

    public PelayananDTO getPelayananDTO() {
        return pelayananDTO;
    }

    public void setPelayananDTO(PelayananDTO pelayananDTO) {
        this.pelayananDTO = pelayananDTO;
    }

    public ListModelList<String> getListKelompokLayanan() {
        listKelompokLayanan.add("Kelompok 1");
        listKelompokLayanan.add("Kelompok 2");
        listKelompokLayanan.add("Kelompok 3");
        listKelompokLayanan.add("Kelompok 4");
        listKelompokLayanan.add("Kelompok 5");
        return listKelompokLayanan;
    }

    public void setListKelompokLayanan(ListModelList<String> listKelompokLayanan) {
        this.listKelompokLayanan = listKelompokLayanan;
    }

    public ListModelList<PelayananStatus> getListStatusPelayanan() {
        return new ListModelList<>(PelayananStatus.values());
    }

    public void setListStatusPelayanan(ListModelList<PelayananStatus> listStatusPelayanan) {
        this.listStatusPelayanan = listStatusPelayanan;
    }

    public String getLayananID() {
        return layananID;
    }

    public void setLayananID(String layananID) {
        this.layananID = layananID;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public PelayananStatus getStatus() {
        return status;
    }

    public void setStatus(PelayananStatus status) {
        this.status = status;
    }

    public List<PelayananDTO> getPelayananDTOs() {
        return pelayananDTOs;
    }

    public void setPelayananDTOs(List<PelayananDTO> pelayananDTOs) {
        this.pelayananDTOs = pelayananDTOs;
    }

}

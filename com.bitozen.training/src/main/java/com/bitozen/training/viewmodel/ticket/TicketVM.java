package com.bitozen.training.viewmodel.ticket;

import com.bitozen.training.application.TicketService;
import com.bitozen.training.common.status.StatusTicket;
import com.bitozen.training.common.type.Priority;
import com.bitozen.training.common.type.TypeTicket;
import com.bitozen.training.common.zul.CommonViewModel;
import static com.bitozen.training.common.zul.CommonViewModel.showInformationMessagebox;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTOBuilder;
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
 * @author brian
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TicketVM {

    @WireVariable
    TicketService ticketService;

    /* Object Binding for Form Create Ticket*/
    private TicketDTO ticketDTO;

    /* Object Binding for Form Search Ticket*/
    private List<TicketDTO> ticketDTOs = new ArrayList<>();

    /* Attribut for Searching Ticket */
    private String ticketID;
    private String ticketName;
    private TypeTicket ticketType;
    private StatusTicket ticketStatus;

    /* Object for List Something in Combobox */
    private ListModelList<String> listUserID = new ListModelList<>();
    private ListModelList<TypeTicket> listTypeTicket = new ListModelList<>();
    private ListModelList<Priority> listPriorityTicket = new ListModelList<>();
    private ListModelList<StatusTicket> listStatusTicket = new ListModelList<>();

    @Init
    public void init(
            @ExecutionArgParam("ticketDTO") TicketDTO ticket) {

        /* Load Data */
        initData();

        /* Check Validity */
        checkValidity(ticket);
    }

    private void initData() {
        /* get all pelayanan */
        ticketDTOs = ticketService.findAll();

        /* add list id user for combobox*/
        listUserID.add("LINTANG KECIL");
        listUserID.add("BAYU HENDRA");
        listUserID.add("WIWIT SETYO P");
        listUserID.add("ANGGA SYAHPUTRA");

    }

    private void checkValidity(TicketDTO ticket) {
        if (ticket == null) {
            ticketDTO = new TicketDTOBuilder()
                    .setTypeTicket(TypeTicket.INCIDENT)
                    .setCreatedBy("administrator")
                    .setCreatedDate(new Date())
                    .createTicketDTO();
        } else {
            this.ticketDTO = ticket;
            ticketID = ticketDTO.getTicketID();
            ticketName = ticketDTO.getTittleTicket();
            ticketType = ticketDTO.getTypeTicket();
            ticketStatus = ticketDTO.getStatusTicket();
        }
    }

    @Command("buttonPencarian")
    @NotifyChange("ticketDTOs")
    public void buttonPencarian(@ContextParam(ContextType.VIEW) Window window) {

        Map params = new HashMap();
        params.put("ticketID", ticketID);
        params.put("tittleTicket", ticketName);
        params.put("typeTicket", ticketType);
        params.put("statusTicket", ticketStatus);

        ticketDTOs = ticketService.findByParams(params);
    }

    @Command("buttonCreateTicket")
    @NotifyChange("ticketDTO")
    public void buttonCreateTicket(@BindingParam("object") TicketDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("ticketDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/Layout/Create_Ticket.zul", window, params);
    }

    @Command("buttonSaveTicket")
    @NotifyChange({"ticketDTO", "ticketDTOs"})
    public void buttonSaveTicket(@BindingParam("object") TicketDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        ticketService.saveTicket(ticketDTO);
        showInformationMessagebox("Ticket Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();

    }

    @GlobalCommand
    @NotifyChange("ticketDTOs")
    public void refreshData() {
        ticketDTOs = ticketService.findAll();
    }

    @Command("detailTicket")
    @NotifyChange("ticketDTO")
    public void detailTicket(@BindingParam("object") TicketDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("ticketDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/Layout/Create_Ticket.zul", window, params);
    }

    @Command("deleteTicket")
    @NotifyChange("ticketDTOs")
    public void deleteTicket(@BindingParam("object") TicketDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        ticketDTO = (TicketDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Ticket?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            ticketService.deleteTicket(ticketDTO);
                            showInformationMessagebox("Ticket Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshData", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    @Command("buttonCancel")
    @NotifyChange("ticketDTO")
    public void buttonCancel(@BindingParam("object") TicketDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    /* getter and setter */
    public TicketDTO getTicketDTO() {
        return ticketDTO;
    }

    public void setTicketDTO(TicketDTO ticketDTO) {
        this.ticketDTO = ticketDTO;
    }

    public List<TicketDTO> getTicketDTOs() {
        return ticketDTOs;
    }

    public void setTicketDTOs(List<TicketDTO> ticketDTOs) {
        this.ticketDTOs = ticketDTOs;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public TypeTicket getTicketType() {
        return ticketType;
    }

    public void setTicketType(TypeTicket ticketType) {
        this.ticketType = ticketType;
    }

    public StatusTicket getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(StatusTicket ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public ListModelList<String> getListUserID() {
        return listUserID;
    }

    public void setListUserID(ListModelList<String> listUserID) {
        this.listUserID = listUserID;
    }

    public ListModelList<TypeTicket> getListTypeTicket() {
        return new ListModelList<>(TypeTicket.values());
    }

    public void setListTypeTicket(ListModelList<TypeTicket> listTypeTicket) {
        this.listTypeTicket = listTypeTicket;
    }

    public ListModelList<Priority> getListPriorityTicket() {
        return new ListModelList<>(Priority.values());
    }

    public void setListPriorityTicket(ListModelList<Priority> listPriorityTicket) {
        this.listPriorityTicket = listPriorityTicket;
    }

    public ListModelList<StatusTicket> getListStatusTicket() {
        return new ListModelList<>(StatusTicket.values());
    }

    public void setListStatusTicket(ListModelList<StatusTicket> listStatusTicket) {
        this.listStatusTicket = listStatusTicket;
    }

}

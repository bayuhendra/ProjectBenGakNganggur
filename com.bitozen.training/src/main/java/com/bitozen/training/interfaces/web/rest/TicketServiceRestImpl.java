package com.bitozen.training.interfaces.web.rest;

import com.bitozen.training.application.TicketService;
import com.bitozen.training.interfaces.web.facade.TicketServiceFecade;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
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
 * @author ASUS
 */
@Controller
public class TicketServiceRestImpl implements TicketServiceFecade {

    @Autowired
    private TicketService ticketService;

    @Override
    @RequestMapping(value = "/bitozen.service.ticket", method = RequestMethod.POST)
    public ResponseEntity<Void> submitTicket(@RequestBody TicketDTO ticketDTO) {
        Validate.notNull(ticketService);
        ticketService.saveTicket(ticketDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bitozen.service.ticket.get.dummy", method = RequestMethod.GET)
    public ResponseEntity<TicketDTO> getTicketDummy() {
        return new ResponseEntity<>(ticketService.getDummy(), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.ticket.get/{id}", method = RequestMethod.GET)
    public ResponseEntity<TicketDTO> findByID(@PathVariable("id") String id) {
        TicketDTO ticketDTO = ticketService.findByID(id);
        if (ticketDTO != null) {
            return new ResponseEntity<>((ticketDTO), HttpStatus.FOUND);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/bitozen.service.ticket.get.all", method = RequestMethod.GET)
    public ResponseEntity<List<TicketDTO>> findAll() {
        return new ResponseEntity<>((ticketService.findAll()), HttpStatus.FOUND);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.ticket.delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.deleteTicket(ticketDTO);
        return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }

    @Override
    @RequestMapping(value = "/bitozen.service.ticket.get.params/{typeTicket}", method = RequestMethod.GET)
    public ResponseEntity<List<TicketDTO>> findByParams(Map map) {
        return new ResponseEntity<>((ticketService.findByParams(map)), HttpStatus.FOUND);
    }

}

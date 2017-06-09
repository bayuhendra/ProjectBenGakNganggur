
import com.bitozen.training.application.TicketService;
import com.bitozen.training.common.type.TypeTicket;
import com.bitozen.training.domain.model.ticket.TicketRepository;
import com.bitozen.training.interfaces.web.facade.dto.ticket.TicketDTO;
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
public class TicketServiceTest {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketService ticketService;

    @Test
    public void TicketServiceTest() {
        Validate.notNull(ticketRepository);

        print("Ticket Processing");
        /* Ticket */

        TicketDTO ticket = ticketService.getDummy();
        System.out.println("Ticket :" + ticket.toString());

        ticketService.saveTicket(ticket);
        System.out.println("Ticket has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        TicketDTO t = ticketService.findByID(ticket.getTicketID());
        System.out.println("Ticket :" + t.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<TicketDTO> listTicket = ticketService.findAll();
        for (TicketDTO tk : listTicket) {
            System.out.println("Ticket :" + tk.toString());
        }

        System.out.println("");
        System.out.println("Find Params");
        Map map = new HashMap();
        map.put("typeTicket", TypeTicket.REQUEST);
        List<TicketDTO> listTicketParams = ticketService.findByParams(map); 
        for (TicketDTO tk : listTicketParams) {
            System.out.println("Ticket :" + tk.toString());
        }

    }

    private void print(String msg) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------");
    }
}

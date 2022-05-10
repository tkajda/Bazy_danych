package ProjectBackend.webservice;

import ProjectBackend.Model.tickets.Discount;
import ProjectBackend.Model.tickets.KnownDiscountName;
import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.data.tickets.TicketDBController;
//import ProjectBackend.data.tickets.TicketRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;

@Service
@RestController
@RequestMapping("/routes")
public class TicketController {
    @Autowired
    TicketDBController ticketDBController;
    public TicketController(TicketDBController ticketDBController){this.ticketDBController=ticketDBController;}
    @RequestMapping(path="/ticket",method= RequestMethod.POST)
    public ResponseEntity<String> buyTicket(Ticket ticket){
        Gson gson=new Gson();
        if(!ticketDBController.saveTicket(ticket)){
            return ResponseEntity.status(540).body("{Ticket cannot be bought}");
        }
        return ResponseEntity.ok().body(gson.toJson(ticket));
    }
}

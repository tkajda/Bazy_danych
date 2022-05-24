package ProjectBackend.webservice;

import ProjectBackend.Model.tickets.Discount;
import ProjectBackend.Model.tickets.KnownDiscountName;
import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.Model.users.User;
import ProjectBackend.Model.users.UserIdentifier;
import ProjectBackend.data.logic.TicketLogic;
import ProjectBackend.data.tickets.TicketDBController;
import ProjectBackend.data.tickets.TicketRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RestController
@RequestMapping("/routes")
public class TicketController {
    @Autowired
    TicketLogic ticketLogic;
    public TicketController(TicketLogic ticketLogic){
        this.ticketLogic=ticketLogic;
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(path="/ticket",method= RequestMethod.POST)

    public ResponseEntity<String> buyTicket(@RequestBody Ticket ticket){

        boolean reserveTicket =ticketLogic.reserveTicket(ticket);

        if(!reserveTicket){
            return ResponseEntity.status(540).body("{Response:Ticket cannot be bought}");
        }
        return ResponseEntity.ok().body(new Gson().toJson(ticket));
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(path="/tickets",method=RequestMethod.GET)
    public ResponseEntity<String> getTickets(UserIdentifier userIdentifier){
        System.out.println(userIdentifier.getUserID());
        return ResponseEntity.ok().body(new Gson().toJson(this.ticketLogic.getTickets(userIdentifier.getUserID())));
    }
}

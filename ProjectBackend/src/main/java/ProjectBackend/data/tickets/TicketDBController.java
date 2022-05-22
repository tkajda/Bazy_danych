package ProjectBackend.data.tickets;

import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.data.routes.RoutesRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TicketDBController {

    private TicketRepository ticketRepository;
    private RoutesRepository routesRepository;


    public TicketDBController(TicketRepository ticketRepository, RoutesRepository routesRepository){
        this.ticketRepository=ticketRepository;
        this.routesRepository=routesRepository;
    }

    public boolean saveTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
        return true;
    }
    public List<Ticket> getTickets(Integer userId){
        return this.ticketRepository.getTicketsByUserId(userId);
    }

}

package ProjectBackend.data.tickets;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.Model.users.User;
import ProjectBackend.data.routes.RoutesRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Configuration
public class TicketDBController {
    private TicketRepository ticketRepository;
    private RoutesRepository routesRepository;
    public TicketDBController(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }
    public boolean saveTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
        return true;
    }
    public List<Ticket> getTickets(Integer userId){
        return this.ticketRepository.getTicketsByUserId(userId);
    }

}

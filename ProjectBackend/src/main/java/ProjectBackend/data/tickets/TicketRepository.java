package ProjectBackend.data.tickets;


import ProjectBackend.Model.tickets.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket,String> {

    public List<Ticket> getTicketsByUserId(Integer userId);
}

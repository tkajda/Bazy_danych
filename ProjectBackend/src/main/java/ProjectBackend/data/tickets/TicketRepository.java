package ProjectBackend.data.tickets;


import ProjectBackend.Model.tickets.Ticket;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket,String> {

    @Query("{'userId':?0}")
    public List<Ticket> getTicketsByUserId(Integer userId);



}

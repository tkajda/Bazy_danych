package ProjectBackend.data.logic;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.Routes.TrainStop;
import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.data.routes.RoutesDBController;
import ProjectBackend.data.tickets.TicketDBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.sql.Date;
import java.util.List;

@Configuration
public class TicketLogic {
    @Autowired
    private TicketDBController ticketDBController;
    @Autowired
    private RoutesDBController routesDBController;

    @Autowired
    private MongoTemplate mongoTemplate;

    public TicketLogic(TicketDBController ticketDBController, RoutesDBController routesDBController) {
        this.ticketDBController = ticketDBController;
        this.routesDBController = routesDBController;
    }

    public TicketDBController getTicketDBController() {
        return ticketDBController;
    }

    public void setTicketDBController(TicketDBController ticketDBController) {
        this.ticketDBController = ticketDBController;
    }

    public RoutesDBController getRoutesDBController() {
        return routesDBController;
    }

    public void setRoutesDBController(RoutesDBController routesDBController) {
        this.routesDBController = routesDBController;
    }

    public boolean reserveTicket(Ticket ticket) {

        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(ticket.getRouteID()));

        Route route = mongoTemplate.findOne(query, Route.class, "Routes");
        System.out.println(ticket.getRouteID());


        assert route != null;
        route.getTrainStops().forEach(trainStop -> {
            System.out.println(trainStop.getStationName());
        });

        int n = route.getTrainStops().size();

        //validation on the route
        for (int i = 0; i < n; i++) {
            TrainStop firstStation = route.getTrainStops().get(i);
            if (firstStation.getStationName().equals(ticket.getStartingStation())) {
                for (int j = i; j < n; j++) {
                    TrainStop nextStop = route.getTrainStops().get(j);
                    if (nextStop.getStationName().equals(ticket.getEndingStation())) {
                        break;
                    }
                    if ((nextStop.getCompartmentSeats() <= 0 && ticket.getCompartmentSeat()) || (nextStop.getNonCompartmentSeats() <= 0 && !ticket.getCompartmentSeat())) {
                        //Undo for previous opertaions
                        for (int x = j; x >= 0; x--) {
                            if (nextStop.getStationName().equals(ticket.getEndingStation())) {
                                break;
                            }
                            if (ticket.getCompartmentSeat()) {
                                nextStop.setCompartmentSeats(nextStop.getCompartmentSeats() + 1);
                                continue;
                            }
                            nextStop.setNonCompartmentSeats(nextStop.getNonCompartmentSeats() + 1);
                        }
                        return false;
                    }
                    if (ticket.getCompartmentSeat()) {
                        nextStop.setCompartmentSeats(nextStop.getCompartmentSeats() - 1);
                        continue;
                    }
                    nextStop.setNonCompartmentSeats(nextStop.getNonCompartmentSeats() - 1);
                }
                break;
            }
        }

        findSeat(ticket, route);

        ticketDBController.saveTicket(ticket);

        Update updateObject = new Update();
        updateObject.set("trainStops", route.getTrainStops());
        mongoTemplate.updateFirst(query, updateObject, Route.class);
        return true;
    }

    public void findSeat(Ticket ticket, Route route) {
        if(ticket.getCompartmentSeat()){
            if(route.getTakenCompartmentSeats().size()<route.getTrain().getCompartmentSeats()){
                for(Integer i=0;i<route.getTrain().getCompartmentSeats();i++){
                    if(!route.getTakenCompartmentSeats().contains(i)){
                        route.getTakenCompartmentSeats().add(i);
                        ticket.setSeatNo(i);
                    }
                }
            }
            else  {
                route.getTakenCompartmentSeats().add(0);
                ticket.setSeatNo(0);
            }

        }
        else {
            if(route.getTakenNonCompartmentSeats().size()<route.getTrain().getNonCompartmentSeats()){
                for(Integer i=0;i<route.getTrain().getCompartmentSeats();i++){
                    if(!route.getTakenNonCompartmentSeats().contains(i)){
                        route.getTakenNonCompartmentSeats().add(i);
                        ticket.setSeatNo(i);
                    }
                }
            }
            else {
                route.getTakenNonCompartmentSeats().add(0);
                ticket.setSeatNo(0);
            }
        }
    }


    public List<Ticket> getTickets(Integer userId){
        return this.ticketDBController.getTickets(userId);
    }


}
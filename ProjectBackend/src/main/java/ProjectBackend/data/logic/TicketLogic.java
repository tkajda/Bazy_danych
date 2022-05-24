package ProjectBackend.data.logic;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.Routes.TrainStop;
import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.Model.utility.SeatSearchSet;
import ProjectBackend.data.routes.RoutesDBController;
import ProjectBackend.data.tickets.TicketDBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.math.BigDecimal;
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
        findSeat(ticket,route);
        if(ticket.getSeatNo()==-1){
            return false;
        }
        Integer distance=0;
        //validation on the route
        for (int i = 0; i < n; i++) {
            TrainStop firstStation = route.getTrainStops().get(i);
            if (firstStation.getStationName().equals(ticket.getStartingStation())) {
                for (int j = i; j < n; j++) {
                    TrainStop nextStop = route.getTrainStops().get(j);
                    if(nextStop.getStationName().equals(ticket.getEndingStation())){
                        distance=nextStop.getDistanceFromBeginning()-firstStation.getDistanceFromBeginning();
                        break;
                    }
                    if(ticket.getCompartmentSeat()){
                            nextStop.getCompartmentSeats().add(ticket.getSeatNo());
                    }
                    else{
                        nextStop.getNonCompartmentSeats().add(ticket.getSeatNo());
                    }

                }
                break;
            }
        }
        ticket.setPrice(BigDecimal.valueOf(5+distance/10).multiply(BigDecimal.ONE.subtract(ticket.getDiscount().discountValue)));
        ticketDBController.saveTicket(ticket);
        Update updateObject = new Update();
        updateObject.set("trainStops", route.getTrainStops());
        mongoTemplate.updateFirst(query, updateObject, Route.class);
        return true;
    }

    public void findSeat(Ticket ticket, Route route) {

        if(ticket.getCompartmentSeat()){
            SeatSearchSet set=new SeatSearchSet(route.getTrain().getCompartmentSeats());
            List<TrainStop> stops=route.getTrainStops();
            int n=stops.size();
            for(int i=0;i<n;i++){
                TrainStop firstStation=route.getTrainStops().get(i);
                if(firstStation.getStationName().equals(ticket.getStartingStation())){
                    for(int j=i;j<n;j++){
                        if(route.getTrainStops().get(j).getStationName().equals(ticket.getEndingStation())){
                            break;
                        }
                        for(Integer taken:route.getTrainStops().get(j).getCompartmentSeats()){
                            set.addTakenSeat(taken);
                        }

                    }
                    break;
                }
            }
            ticket.setSeatNo(set.getFirstUntaken());
        }
        else {
            SeatSearchSet set=new SeatSearchSet(route.getTrain().getNonCompartmentSeats());
            List<TrainStop> stops=route.getTrainStops();
            int n=stops.size();
            for(int i=0;i<n;i++){
                TrainStop firstStation=route.getTrainStops().get(i);
                if(firstStation.getStationName().equals(ticket.getStartingStation())){
                    for(int j=i;j<n;j++){
                        if(route.getTrainStops().get(j).getStationName().equals(ticket.getEndingStation())){
                            break;
                        }
                        for(Integer taken:route.getTrainStops().get(j).getNonCompartmentSeats()){
                            set.addTakenSeat(taken);
                        }

                    }
                    break;
                }
            }
            ticket.setSeatNo(set.getFirstUntaken());
        }
    }


    public List<Ticket> getTickets(Integer userId){
        return this.ticketDBController.getTickets(userId);
    }


}
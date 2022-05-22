package ProjectBackend.data.logic;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.tickets.Ticket;
import ProjectBackend.data.routes.RoutesDBController;
import ProjectBackend.data.tickets.TicketDBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class TicketLogic {
    @Autowired
    private TicketDBController ticketDBController;
    @Autowired
    private RoutesDBController routesDBController;

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
    public Ticket reserveTicket(Ticket ticket){
        Route route=this.routesDBController.getRouteById(ticket.getRouteID()).get(0);
        if(ticket.getCompartmentSeat()){
            if(route.getTakenCompartmentSeats().size()<route.getTrain().getCompartmentSeats()){
                for(Integer i=0;i<route.getTrain().getCompartmentSeats();i++){
                    if(!route.getTakenCompartmentSeats().contains(i)){
                        route.getTakenCompartmentSeats().add(i);
                        ticket.setSeatNo(i);
                        //ticket.setTicketDate(new Date(date.getTime()));
                        ticketDBController.saveTicket(ticket);
                        routesDBController.saveRoute(route);
                        return ticket;
                    }
                }
            }
            return new Ticket();
        }
        else{
            if(route.getTakenNonCompartmentSeats().size()<route.getTrain().getNonCompartmentSeats()){
                for(Integer i=0;i<route.getTrain().getCompartmentSeats();i++){
                    if(!route.getTakenNonCompartmentSeats().contains(i)){
                        route.getTakenNonCompartmentSeats().add(i);
                        ticket.setSeatNo(i);
                        //ticket.setTicketDate(new Date(date.getTime()));
                        ticketDBController.saveTicket(ticket);
                        routesDBController.saveRoute(route);
                        return ticket;
                    }
                }
            }
            return new Ticket();
        }
    }
    public List<Ticket> getTickets(Integer userId){
        return this.ticketDBController.getTickets(userId);
    }


}

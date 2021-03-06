package ProjectBackend.data.routes;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.Routes.RouteFinderParams;
import ProjectBackend.Model.tickets.Ticket;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.Date;
import java.util.List;

public interface RoutesRepository extends MongoRepository<Route ,String> {

    @Aggregation(pipeline={
            "{$match:{'travelDate':?3}}",
            "{$unwind:'$trainStops'}",
            "{$match:{'trainStops.stationName':{$in:[?0,?1]}}}",
            "{$group:{_id:'$_id', firstStation:{$first:'$trainStops.stationName'},lastStation:{$last:'$trainStops.stationName'},departureTime:{$first:'$trainStops.departureTime'},arrivalTime:{$last:'$trainStops.arrivalTime'}}}",
            "{$match:{'firstStation':?0}}",
            "{$match:{'lastStation':?1}}",
            "{$match:{'$expr':{'$gt':['$departureTime',?2]}}}"
    })
    List<RouteFinderParams> getRoutes(String startingCity, String endingCity, String departureTime, String travelDate);

    Route getRoutesByRouteID(String routeID);
}
package ProjectBackend.data.routes;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.Routes.RouteFinderParams;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoutesRepository extends MongoRepository<Route ,String> {
    @Aggregation(pipeline={
            "{$unwind:'$trainStops'}",
            "{$match:{'trainStops.stationName':{$in:[?0,?1]}}}",
            "{$group:{_id:'$_id', firstStation:{$first:'$trainStops.stationName'},lastStation:{$last:'$trainStops.stationName'},departureTime:{$first:'$trainStops.departureTime'},arrivalTime:{$last:'$trainStops.arrivalTime'}}}",
            "{$match:{'$expr':{'$lt':['$departureTime','$arrivalTime']}}}",
            "{$match:{'$expr':{'$ne':['$departureTime',null]}}}",
            "{$match:{'$expr':{'ne':['$arrivalTime',null]}}}"
            })
    List<RouteFinderParams> getRoutes(String startingCity, String endingCity, String departureTime);

}

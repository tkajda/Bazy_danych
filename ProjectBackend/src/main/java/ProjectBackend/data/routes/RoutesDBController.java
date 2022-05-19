package ProjectBackend.data.routes;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.Routes.RouteFinderParams;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class RoutesDBController {
    private RoutesRepository routesRepository;


    public RoutesDBController(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public RoutesRepository getRoutesRepository() {
        return routesRepository;
    }

    public void setRoutesRepository(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public boolean saveRoute(Route route){
        System.out.println(route.getTravelDate());
        this.routesRepository.save(route);
        return true;
    }
    public List<RouteFinderParams> getRoutes(RouteFinderParams params){
//        RouteFinderParams params=new RouteFinderParams("Kielce","Warszawa","10:00:00","", Date.valueOf("2022-05-07"));
        String startCity = params.getFirstStation();
        String lastCity = params.getLastStation();
        String departureTime = params.getDepartureTime();
        Date date = params.getTravelDate();

//        routesRepository

        return this.routesRepository.getRoutes(
                params.getFirstStation(),
                params.getLastStation(),
                params.getDepartureTime());
    }
}

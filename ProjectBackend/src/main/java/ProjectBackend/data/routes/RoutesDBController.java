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
        this.routesRepository.save(route);
        return true;
    }
    public List<RouteFinderParams> getRoutes(){
        RouteFinderParams params=new RouteFinderParams("Kielce","Warszawa","10:00:00","", Date.valueOf("2022-05-07"));
        return this.routesRepository.getRoutes(
                params.getFirstStation(),
                params.getLastStation(),
                params.getDepartureTime());
    }
}

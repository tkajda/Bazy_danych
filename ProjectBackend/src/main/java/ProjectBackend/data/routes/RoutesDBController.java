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
    public List<RouteFinderParams> getRoutes(RouteFinderParams params){

        return this.routesRepository.getRoutes(
                params.getFirstStation(),
                params.getLastStation(),
                params.getDepartureTime());
    }
}

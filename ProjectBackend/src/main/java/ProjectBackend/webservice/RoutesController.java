package ProjectBackend.webservice;

import ProjectBackend.Model.Routes.Route;
import ProjectBackend.Model.Routes.RouteFinderParams;
import ProjectBackend.data.routes.RoutesDBController;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/routes")
public class RoutesController {
    @Autowired
    RoutesDBController routesDBController;

    public RoutesController(RoutesDBController dbController) {
        this.routesDBController = dbController;
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping("/find")
    public ResponseEntity<String> findConnection(RouteFinderParams params){
        System.out.println(params.toString());
        return ResponseEntity.ok().body(new Gson().toJson(routesDBController.getRoutes()));
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping("/add")
    public ResponseEntity<String> addConnection(@RequestBody Route route){
        if(!this.routesDBController.saveRoute(route)){
            return ResponseEntity.status(550).body("{Response:The route could not be added}");
        }

        return ResponseEntity.ok().body(new Gson().toJson(route));
    }


}

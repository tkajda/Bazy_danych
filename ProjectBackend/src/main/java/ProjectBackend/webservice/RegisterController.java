package ProjectBackend.webservice;

import ProjectBackend.Model.users.User;
import ProjectBackend.data.users.UsersDBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UsersDBController usersDBController;
    public RegisterController(UsersDBController usersDBController){
        this.usersDBController=usersDBController;
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(path="/submit",method= RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user){

        if(this.usersDBController.addUser(user)){
            return ResponseEntity.status(200).body("{OK}");
        }
        return ResponseEntity.status(580).body("{user with given username exists}");

    }
}

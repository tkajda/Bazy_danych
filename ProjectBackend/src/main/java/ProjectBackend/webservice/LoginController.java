package ProjectBackend.webservice;

import ProjectBackend.Model.users.User;
import ProjectBackend.data.users.UsersDBController;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UsersDBController usersDBController;

    public LoginController(UsersDBController usersDBController){
        this.usersDBController=usersDBController;
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(path="/submit",method= RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody User user){

        System.out.println(user.getUsername()+" "+user.getPassword());
        User loggedUser=this.usersDBController.login(user.getUsername(),user.getPassword());

        if(loggedUser.getUserID()!=null){
            return ResponseEntity.ok().body(new Gson().toJson(loggedUser));
        }
        return ResponseEntity.status(555).body("{message:wrong login or password}");
    }
}

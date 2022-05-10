package ProjectBackend.webservice;

import ProjectBackend.Model.users.User;
import ProjectBackend.data.users.UsersDBController;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean addUser(@RequestBody User user){
        return this.usersDBController.addUser(user);

    }
}

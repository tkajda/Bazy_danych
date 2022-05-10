package ProjectBackend.webservice;

import ProjectBackend.data.users.UsersDBController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UsersDBController usersDBController;
    public RegisterController(UsersDBController usersDBController){
        this.usersDBController=usersDBController;
    }
    @RequestMapping(path="/submit",method= RequestMethod.POST)
    public boolean addUser(@RequestParam(value="username",required = true)String username, @RequestParam(value="password",required = true)String password){
        return this.usersDBController.addUser(username,password);

    }
}

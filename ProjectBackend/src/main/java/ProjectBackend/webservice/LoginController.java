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
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UsersDBController usersDBController;

    public LoginController(UsersDBController usersDBController){
        this.usersDBController=usersDBController;
    }
    @RequestMapping(path="/submit",method= RequestMethod.POST)
    public String login(@RequestParam(value="username",required = true)String username, @RequestParam(value="password",required = true)String password){
        return this.usersDBController.login(username,password);
    }
}

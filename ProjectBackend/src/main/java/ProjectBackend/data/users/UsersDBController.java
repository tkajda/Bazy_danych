package ProjectBackend.data.users;

import ProjectBackend.Model.users.User;
import ProjectBackend.data.users.UserRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersDBController {
    public final UserRepository userRepository;
    public UsersDBController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean addUser(String username, String password){
        if(this.userRepository.findByUsername(username).size()==1){
            return false;
        }
        this.userRepository.save(new User(username,password));
        return true;
    }
    public String login(String username, String password){
        List<User> users=this.userRepository.findByUsername(username);
        if(users.size()==0){
            return "USERNAME NOT FOUND";
        }
        if(users.get(0).password.equals(password)){
            return "LOGIN OK";
        }
        else{
            return "WRONG PASSWORD";
        }
    }
}

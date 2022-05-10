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
    public boolean addUser(User user){
        if(this.userRepository.findByUsername(user.getUsername()).size()==1){
            return false;
        }
        this.userRepository.save(user);
        return true;
    }
    public boolean login(String username, String password){
        List<User> users=this.userRepository.findByUsername(username);
        if(users.size()==0){
            return false;
        }
        return users.get(0).password.equals(password);
    }
}

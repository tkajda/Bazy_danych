package ProjectBackend.Model.users;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userID")
    public Integer userID;

    @Column(name="username")
    public String username;

    @Column(name="password")
    public String password;

    @Column(name="key")
    public String key;

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }
    public User(){

    }
}

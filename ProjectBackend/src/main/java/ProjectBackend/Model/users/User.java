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

    @Column(name="firstName")
    public String firstName;

    @Column(name="lastName")
    public String lastName;

    @Column(name="email")
    public String email;

    @Column(name="city")
    public String city;

    @Column(name="country")
    public String country;

    @Column(name="zip")
    public String zip;

    @Column(name="address")
    public String address;

    public User(){

    }

    public User(Integer userID, String username, String password, String key, String firstName, String lastName, String email, String city, String country, String zip, String address) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.address = address;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

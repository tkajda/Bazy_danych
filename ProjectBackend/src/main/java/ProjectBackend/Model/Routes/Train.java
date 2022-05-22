package ProjectBackend.Model.Routes;

import org.springframework.data.annotation.Id;

public class Train {
    private Integer compartmentSeats;
    private Integer nonCompartmentSeats;
    @Id
    private String number;

    public Train(Integer compartmentSeats, Integer nonCompartmentSeats) {
        this.compartmentSeats = compartmentSeats;
        this.nonCompartmentSeats = nonCompartmentSeats;
    }

    public Train(String id){
        this.number = id;
    }

    public Train(){

    }

    public Integer getCompartmentSeats() {
        return compartmentSeats;
    }

    public void setCompartmentSeats(Integer compartmentSeats) {
        this.compartmentSeats = compartmentSeats;
    }

    public Integer getNonCompartmentSeats() {
        return nonCompartmentSeats;
    }

    public void setNonCompartmentSeats(Integer nonCompartmentSeats) {
        this.nonCompartmentSeats = nonCompartmentSeats;
    }
}

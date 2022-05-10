package ProjectBackend.Model.Routes;

public class Train {
    private Integer compartmentSeats;
    private Integer nonCompartmentSeats;

    public Train(Integer compartmentSeats, Integer nonCompartmentSeats) {
        this.compartmentSeats = compartmentSeats;
        this.nonCompartmentSeats = nonCompartmentSeats;
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

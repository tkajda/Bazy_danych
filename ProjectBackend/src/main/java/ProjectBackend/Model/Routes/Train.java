package ProjectBackend.Model.Routes;

public class Train {
    private Integer compartmentSeats;
    private Integer nonCompartmentSeats;
    private String number;

//    public Train(Integer compartmentSeats, Integer nonCompartmentSeats) {
//        this.compartmentSeats = compartmentSeats;
//        this.nonCompartmentSeats = nonCompartmentSeats;
//    }

    public Train(String number,Integer compartmentSeats, Integer nonCompartmentSeats){
        this.number = number;
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

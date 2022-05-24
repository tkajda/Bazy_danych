package ProjectBackend.Model.Routes;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TrainStop {
    private String stationName;
    private String arrivalTime;
    private String departureTime;
    private List<Integer> compartmentSeats;
    private List<Integer> nonCompartmentSeats;
    private Integer distanceFromBeginning;


    public TrainStop(String stationName, String arrivalTime, String departureTime, Integer distanceFromBeginning) {
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.compartmentSeats = new ArrayList<>();
        this.nonCompartmentSeats = new ArrayList<>();
        this.distanceFromBeginning=distanceFromBeginning;
    }


    public List<Integer> getCompartmentSeats() {
        return compartmentSeats;
    }

    public void setCompartmentSeats(List<Integer> compartmentSeats) {
        this.compartmentSeats = compartmentSeats;
    }

    public List<Integer> getNonCompartmentSeats() {
        return nonCompartmentSeats;
    }

    public Integer getDistanceFromBeginning() {
        return distanceFromBeginning;
    }

    public void setDistanceFromBeginning(Integer distanceFromBeginning) {
        this.distanceFromBeginning = distanceFromBeginning;
    }

    public void setNonCompartmentSeats(List<Integer> nonCompartmentSeats) {
        this.nonCompartmentSeats = nonCompartmentSeats;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}

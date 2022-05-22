package ProjectBackend.Model.Routes;

import java.sql.Time;
import java.sql.Timestamp;

public class TrainStop {
    private String stationName;
    private String arrivalTime;
    private String departureTime;
    private Integer compartmentSeats;
    private Integer nonCompartmentSeats;

    public TrainStop(String stationName, String arrivalTime, String departureTime, Integer compartmentSeats,  Integer nonCompartmentSeats) {
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.compartmentSeats = compartmentSeats;
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

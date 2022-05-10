package ProjectBackend.Model.Routes;

import java.sql.Time;
import java.sql.Timestamp;

public class TrainStop {
    private String stationName;
    private String arrivalTime;
    private String departureTime;

    public TrainStop(String stationName, String arrivalTime, String departureTime) {
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
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

package ProjectBackend.Model.Routes;

import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;


@Document("Routes")
public class RouteFinderParams {
    private String firstStation;
    private String lastStation;
    private String departureTime;
    private String arrivalTime;
    private Date travelDate;


    public RouteFinderParams(String firstStation, String lastStation, String departureTime, String arrivalTime, Date travelDate) {
        this.firstStation = firstStation;
        this.lastStation = lastStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelDate = travelDate;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    @Override
    public String toString() {
        return "RouteFinderParams{" +
                "firstStation='" + firstStation + '\'' +
                ", lastStation='" + lastStation + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", travelDate=" + travelDate +
                '}';
    }
}

package ProjectBackend.Model.Routes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

@Document("Routes")
public class Route {
    @Id
    private String routeID;

    private String travelDate;
    public ArrayList<TrainStop> trainStops;
    private Train train;


    public Route(String travelDate, ArrayList<TrainStop> trainStops, Train train) {
        this.travelDate = travelDate;
        this.trainStops = trainStops;
        this.train = train;

    }


    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public ArrayList<TrainStop> getTrainStops() {
        return trainStops;
    }

    public void setTrainStops(ArrayList<TrainStop> trainStops) {
        this.trainStops = trainStops;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeID='" + routeID + '\'' +
                ", travelDate='" + travelDate + '\'' +
                ", trainStops=" + trainStops +
                ", train=" + train +
                '}';
    }
}
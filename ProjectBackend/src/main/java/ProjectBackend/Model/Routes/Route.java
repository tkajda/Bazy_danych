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
    private Integer compartmentSeats;
    private Integer nonCompartmentSeats;

    public ArrayList<Integer> takenCompartmentSeats;
    public ArrayList<Integer> takenNonCompartmentSeats;

    public Route(String travelDate, ArrayList<TrainStop> trainStops, Train train, Integer compartmentSeats, Integer nonCompartmentSeats) {
        this.travelDate = travelDate;
        this.trainStops = trainStops;
        this.train = train;
        this.takenCompartmentSeats = new ArrayList<Integer>();
        this.takenNonCompartmentSeats = new ArrayList<Integer>();
        this.compartmentSeats = compartmentSeats;
        this.nonCompartmentSeats = nonCompartmentSeats;

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

    public ArrayList<Integer> getTakenCompartmentSeats() {
        return takenCompartmentSeats;
    }

    public void setTakenCompartmentSeats(ArrayList<Integer> takenCompartmentSeats) {
        this.takenCompartmentSeats = takenCompartmentSeats;
    }

    public ArrayList<Integer> getTakenNonCompartmentSeats() {
        return takenNonCompartmentSeats;
    }

    public void setTakenNonCompartmentSeats(ArrayList<Integer> takenNonCompartmentSeats) {
        this.takenNonCompartmentSeats = takenNonCompartmentSeats;
    }
}
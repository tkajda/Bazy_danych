package ProjectBackend.Model.Routes;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.sql.Date;

@Document("Routes")
public class Route {
    private Date travelDate;
    public ArrayList<TrainStop> trainStops;
    private Train train;
    public ArrayList<Integer> takenCompartmentSeats;
    public ArrayList<Integer> takenNonCompartmentSeats;

    public Route(Date travelDate, ArrayList<TrainStop> trainStops, Train train, ArrayList<Integer> takenCompartmentSeats, ArrayList<Integer> takenNonCompartmentSeats) {
        this.travelDate = travelDate;
        this.trainStops = trainStops;
        this.train = train;
        this.takenCompartmentSeats = takenCompartmentSeats;
        this.takenNonCompartmentSeats = takenNonCompartmentSeats;
    }


    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
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

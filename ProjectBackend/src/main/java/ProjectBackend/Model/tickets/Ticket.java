package ProjectBackend.Model.tickets;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document("tickets")
public class Ticket {
    private Integer trainRouteID;
    private String startingStation;
    private String endingStation;
    private Discount discount;
    private Date ticketDate;
    private String travelerName;
    private String travelerSurname;
    private String travelerEmail;
    private Integer userId;


    public Ticket(Integer trainRouteID, String startingStation, String endingStation, Discount discount, Date ticketDate, String travelerName, String travelerSurname, String travelerEmail, Integer userId) {
        this.trainRouteID = trainRouteID;
        this.startingStation = startingStation;
        this.endingStation = endingStation;
        this.discount = discount;
        this.ticketDate = ticketDate;
        this.travelerName = travelerName;
        this.travelerSurname = travelerSurname;
        this.travelerEmail = travelerEmail;
        this.userId = userId;
    }

    public Integer getTrainRouteID() {
        return trainRouteID;
    }

    public void setTrainRouteID(Integer trainRouteID) {
        this.trainRouteID = trainRouteID;
    }

    public String getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    public String getEndingStation() {
        return endingStation;
    }

    public void setEndingStation(String endingStation) {
        this.endingStation = endingStation;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    public String getTravelerSurname() {
        return travelerSurname;
    }

    public void setTravelerSurname(String travelerSurname) {
        this.travelerSurname = travelerSurname;
    }

    public String getTravelerEmail() {
        return travelerEmail;
    }

    public void setTravelerEmail(String travelerEmail) {
        this.travelerEmail = travelerEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

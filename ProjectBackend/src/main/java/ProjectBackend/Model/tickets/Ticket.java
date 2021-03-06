package ProjectBackend.Model.tickets;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Date;

@Document("tickets")
public class Ticket {
    private String routeID;
    private String startingStation;
    private String endingStation;
    private Discount discount;
    private BigDecimal price;
    private String ticketDate;
    private String travelerName;
    private String travelerSurname;
    private String travelerEmail;
    private Integer userId;
    private Integer seatNo;
    private Boolean compartmentSeat;
    private String travelerCountry;
    private String travelerCity;
    private String travelerZip;
    private String travelerAddress;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Ticket(String routeID, String startingStation, String endingStation, Discount discount, BigDecimal price, String ticketDate, String travelerName, String travelerSurname, String travelerEmail, Integer userId, Integer seatNo, Boolean compartmentSeat, String travelerCountry, String travelerCity, String travelerZip, String travelerAddress) {
        this.routeID = routeID;
        this.startingStation = startingStation;
        this.endingStation = endingStation;
        this.discount = discount;
        this.price = price;
        this.ticketDate = ticketDate;
        this.travelerName = travelerName;
        this.travelerSurname = travelerSurname;
        this.travelerEmail = travelerEmail;
        this.userId = userId;
        this.seatNo = seatNo;
        this.compartmentSeat = compartmentSeat;
        this.travelerCountry = travelerCountry;
        this.travelerCity = travelerCity;
        this.travelerZip = travelerZip;
        this.travelerAddress = travelerAddress;
    }

    public Ticket() {
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
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

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
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

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Boolean getCompartmentSeat() {
        return compartmentSeat;
    }

    public void setCompartmentSeat(Boolean compartmentSeat) {
        this.compartmentSeat = compartmentSeat;
    }

    public String getTravelerCountry() {
        return travelerCountry;
    }

    public void setTravelerCountry(String travelerCountry) {
        this.travelerCountry = travelerCountry;
    }

    public String getTravelerCity() {
        return travelerCity;
    }

    public void setTravelerCity(String travelerCity) {
        this.travelerCity = travelerCity;
    }

    public String getTravelerZip() {
        return travelerZip;
    }

    public void setTravelerZip(String travelerZip) {
        this.travelerZip = travelerZip;
    }

    public String getTravelerAddress() {
        return travelerAddress;
    }

    public void setTravelerAddress(String travelerAddress) {
        this.travelerAddress = travelerAddress;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "routeID='" + routeID + '\'' +
                ", startingStation='" + startingStation + '\'' +
                ", endingStation='" + endingStation + '\'' +
                ", discount=" + discount +
                ", ticketDate=" + ticketDate +
                ", travelerName='" + travelerName + '\'' +
                ", travelerSurname='" + travelerSurname + '\'' +
                ", travelerEmail='" + travelerEmail + '\'' +
                ", userId=" + userId +
                ", seatNo=" + seatNo +
                ", compartmentSeat=" + compartmentSeat +
                ", travelerCountry='" + travelerCountry + '\'' +
                ", travelerCity='" + travelerCity + '\'' +
                ", travelerZip='" + travelerZip + '\'' +
                ", travelerAddress='" + travelerAddress + '\'' +
                '}';
    }
}
package ParkingLotDetails;

import ParkingSpotDetails.ParkingSpot;
import PaymentDetails.Payment;
import VehicleDetails.Vehicle;

import java.sql.Timestamp;

public class ParkingTicket {
    private Integer ticketID;

    private Timestamp startTime;

    private Timestamp endTime;

    private Payment payment;

    private Vehicle vehicle;

    public ParkingTicket(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getTicketID() {
        return ticketID;
    }

}

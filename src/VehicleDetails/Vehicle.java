package VehicleDetails;

import ParkingLotDetails.ParkingTicket;
import ParkingSpotDetails.ParkingSpot;

public abstract class Vehicle {
    private String licenseNo;
    private String colour;

    private ParkingSpot parkingSpot;

    private ParkingTicket parkingTicket;

    public String getLicenseNo() {
        return licenseNo;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public String getColour() {
        return colour;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle(String licenseNo, String colour) {
        this.licenseNo = licenseNo;
        this.colour = colour;
    }
    public abstract boolean assignTicket(ParkingTicket parkingTicket);
}

package VehicleDetails;

import ParkingLotDetails.ParkingTicket;
import ParkingSpotDetails.ParkingSpot;
import VehicleDetails.VisitorPattern.VehicleDispatchVisitor;
import VehicleDetails.VisitorPattern.VehicleVisitor;

public abstract class Vehicle {
    private String licenseNo;
    private String colour;

    private ParkingSpot parkingSpot;

    public abstract void accept(final VehicleVisitor vehicleVisitor);

    public abstract void accept(final VehicleDispatchVisitor vehicleDispatchVisitor);

    public void setParkingSpot(final ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    private ParkingTicket parkingTicket;

    public String getLicenseNo() {
        return licenseNo;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(final ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public String getColour() {
        return colour;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle(final String licenseNo, final String colour) {
        this.licenseNo = licenseNo;
        this.colour = colour;
    }
    public abstract boolean assignTicket(final ParkingTicket parkingTicket);
}

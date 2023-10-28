package VehicleDetails;

import ParkingLotDetails.ParkingTicket;
import VehicleDetails.VisitorPattern.VehicleDispatchVisior;
import VehicleDetails.VisitorPattern.VehicleVisitor;

public class Car extends Vehicle {

    @Override
    public void accept(final VehicleVisitor vehicleVisitor) {
        vehicleVisitor.visit(this);
    }

    @Override
    public void accept(final VehicleDispatchVisior vehicleDispatchVisior) {
        vehicleDispatchVisior.visit(this);
    }

    public Car(final String license, final String colour) {
        super(license, colour);
    }

    @Override
    public boolean assignTicket(final ParkingTicket parkingTicket) {
        parkingTicket.setVehicle(this);
        this.setParkingTicket(parkingTicket);
        return false;
    }
}

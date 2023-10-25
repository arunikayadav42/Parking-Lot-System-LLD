package VehicleDetails;

import ParkingLotDetails.ParkingTicket;
import VehicleDetails.VisitorPattern.VehicleDispatchVisior;
import VehicleDetails.VisitorPattern.VehicleVisitor;

public class Car extends Vehicle {

    @Override
    public void accept(VehicleVisitor vehicleVisitor) {
        vehicleVisitor.visit(this);
    }

    @Override
    public void accept(VehicleDispatchVisior vehicleDispatchVisior) {
        vehicleDispatchVisior.visit(this);
    }

    public Car(String license, String colour) {
        super(license, colour);
    }

    @Override
    public boolean assignTicket(ParkingTicket parkingTicket) {
        parkingTicket.setVehicle(this);
        this.setParkingTicket(parkingTicket);
        return false;
    }
}

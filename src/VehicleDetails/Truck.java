package VehicleDetails;

import ParkingLotDetails.ParkingTicket;
import VehicleDetails.VisitorPattern.VehicleDispatchVisitor;
import VehicleDetails.VisitorPattern.VehicleVisitor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Truck extends Vehicle{

    public Truck(final String license, final String colour) {
        super(license, colour);
    }

    @Override
    public void accept(final VehicleVisitor vehicleVisitor) {
        vehicleVisitor.visit(this);
    }

    @Override
    public void accept(final VehicleDispatchVisitor vehicleDispatchVisitor) {
        vehicleDispatchVisitor.visit(this);
    }

    @Override
    public boolean assignTicket(final ParkingTicket parkingTicket) {
        parkingTicket.setStartTime(new Timestamp(LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC)));
        parkingTicket.setVehicle(this);
        this.setParkingTicket(parkingTicket);
        return false;
    }
}

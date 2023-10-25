package VehicleDetails;

import ParkingLotDetails.ParkingTicket;
import VehicleDetails.VisitorPattern.VehicleDispatchVisior;
import VehicleDetails.VisitorPattern.VehicleVisitor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Motorcycle extends Vehicle{
    @Override
    public void accept(VehicleVisitor vehicleVisitor) {
        vehicleVisitor.visit(this);
    }

    @Override
    public void accept(VehicleDispatchVisior vehicleDispatchVisior) {
        vehicleDispatchVisior.visit(this);
    }

    public Motorcycle(final String license, final String colour) {
        super(license, colour);
    }

    public boolean assignTicket(final ParkingTicket parkingTicket) {
        parkingTicket.setStartTime(new Timestamp(LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC)));
        parkingTicket.setVehicle(this);
        this.setParkingTicket(parkingTicket);
        return false;
    }
}

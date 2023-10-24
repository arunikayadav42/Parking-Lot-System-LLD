package VehicleDetails;

import ParkingLotDetails.ParkingTicket;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Truck extends Vehicle{
    public Truck(final String license, final String colour) {
        super(license, colour);
    }

    @Override
    public boolean assignTicket(final ParkingTicket parkingTicket) {
        parkingTicket.setStartTime(new Timestamp(LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC)));
        parkingTicket.setVehicle(this);
        this.setParkingTicket(parkingTicket);
        return false;
    }
}

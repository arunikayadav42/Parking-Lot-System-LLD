package VehicleDetails;

import ParkingLotDetails.ParkingTicket;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Motorcycle extends Vehicle{
    public Motorcycle(String license, String colour) {
        super(license, colour);
    }

    public boolean assignTicket(ParkingTicket parkingTicket) {
        parkingTicket.setStartTime(new Timestamp(LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC)));
        parkingTicket.setVehicle(this);
        this.setParkingTicket(parkingTicket);
        return false;
    }
}

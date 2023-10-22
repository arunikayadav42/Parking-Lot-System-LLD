package VehicleDetails;

import ParkingLotDetails.ParkingTicket;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Car extends Vehicle {

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

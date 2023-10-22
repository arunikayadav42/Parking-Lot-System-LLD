package ParkingFloor;

import ParkingLotDetails.ParkingTicket;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Entrance {
    private Integer entranceID;

    public Entrance(Integer id) {
        this.entranceID = id;
    }

    public ParkingTicket getParkingTicket(Integer id) {
        ParkingTicket parkingTicket = new ParkingTicket(id);
        parkingTicket.setStartTime(new Timestamp(LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC)));
        return parkingTicket;
    }
}

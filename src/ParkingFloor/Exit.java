package ParkingFloor;

import ParkingLotDetails.ParkingRate;
import ParkingLotDetails.ParkingTicket;
import utils.Constants;

public class Exit {
    private Integer exitID;

    private ParkingRate parkingRate;

    public Exit(Integer id) {
        this.exitID = id;
        parkingRate = new ParkingRate(Constants.PARKING_RATE);
    }

    public double calculateRate(ParkingTicket parkingTicket) {
        return parkingRate.calculateRate(parkingTicket.getEndTime().getNanos() - parkingTicket.getStartTime().getNanos());
    }
}

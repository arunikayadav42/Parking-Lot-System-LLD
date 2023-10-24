package VehicleDetails;

import ParkingLotDetails.ParkingTicket;

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

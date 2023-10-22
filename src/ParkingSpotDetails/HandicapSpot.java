package ParkingSpotDetails;

import VehicleDetails.Vehicle;

import java.util.UUID;

public class HandicapSpot extends ParkingSpot{

    private UUID id;

    public HandicapSpot(UUID uid) {
        this.id = uid;
    }

    @Override
    public boolean parkVehicle(Vehicle incomingVehicle) {
        this.vehicle = incomingVehicle;
        return true;
    }

    @Override
    public boolean unparkVehicle() {
        this.vehicle = null;
        return true;
    }
}

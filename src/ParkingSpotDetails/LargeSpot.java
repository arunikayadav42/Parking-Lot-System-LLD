package ParkingSpotDetails;

import VehicleDetails.Vehicle;

import java.util.UUID;

public class LargeSpot extends ParkingSpot{

    private UUID id;

    public LargeSpot(UUID uid) {
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

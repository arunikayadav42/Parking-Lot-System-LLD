package ParkingSpotDetails;

import VehicleDetails.Vehicle;

import java.util.UUID;

public class HandicapSpot extends ParkingSpot{

    private UUID id;

    public HandicapSpot(final UUID uid) {
        this.id = uid;
    }

    @Override
    protected ParkingSpot createParkingSpot(UUID uid) {
        return new HandicapSpot(uid);
    }

    @Override
    public boolean parkVehicle(final Vehicle incomingVehicle) {
        this.vehicle = incomingVehicle;
        return true;
    }

    @Override
    public boolean unparkVehicle() {
        this.vehicle = null;
        return true;
    }
}

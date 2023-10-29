package ParkingSpotDetails;

import VehicleDetails.Vehicle;

import java.util.UUID;

public class LargeSpot extends ParkingSpot{

    private UUID id;

    public LargeSpot(final UUID uid) {
        this.id = uid;
    }

    @Override
    protected ParkingSpot createParkingSpot(UUID uid) {
        return new LargeSpot(uid);
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

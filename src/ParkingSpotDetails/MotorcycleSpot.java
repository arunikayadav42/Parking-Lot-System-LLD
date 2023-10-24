package ParkingSpotDetails;

import VehicleDetails.Vehicle;

import java.util.UUID;

public class MotorcycleSpot extends ParkingSpot{

    private UUID id;

    public MotorcycleSpot(final UUID uid) {
        this.id = uid;
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

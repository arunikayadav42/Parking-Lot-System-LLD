package ParkingSpotDetails;

import VehicleDetails.Vehicle;

import java.util.UUID;

public abstract class ParkingSpot {
    protected Vehicle vehicle;
    public boolean isAvailable() {
        return vehicle == null;
    }

    public abstract boolean parkVehicle(Vehicle incomingVehicle);

    public abstract boolean unparkVehicle();

    public Vehicle getVehicle() {
        return vehicle;
    }
}

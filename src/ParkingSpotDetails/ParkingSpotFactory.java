package ParkingSpotDetails;

import java.util.UUID;

public abstract class ParkingSpotFactory {
    public ParkingSpot create() {
        UUID id = UUID.randomUUID();
        ParkingSpot parkingSpot = createParkingSpot(id);
        return parkingSpot;
    }

    protected abstract ParkingSpot createParkingSpot(UUID uid);
}

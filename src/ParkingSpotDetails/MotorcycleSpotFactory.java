package ParkingSpotDetails;

import java.util.UUID;

public class MotorcycleSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(UUID uid) {
        return new MotorcycleSpot(uid);
    }
}

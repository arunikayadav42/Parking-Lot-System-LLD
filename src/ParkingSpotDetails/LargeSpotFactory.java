package ParkingSpotDetails;

import java.util.UUID;

public class LargeSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(UUID uid) {
        return new LargeSpot(uid);
    }
}

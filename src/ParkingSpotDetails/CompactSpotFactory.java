package ParkingSpotDetails;

import java.util.UUID;

public class CompactSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(UUID uid) {
        return new CompactSpot(uid);
    }
}

package ParkingSpotDetails;

import java.util.UUID;

public class CompactSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(final UUID uid) {
        return new CompactSpot(uid);
    }
}

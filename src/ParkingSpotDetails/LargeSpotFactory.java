package ParkingSpotDetails;

import java.util.UUID;

public class LargeSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(final UUID uid) {
        return new LargeSpot(uid);
    }
}

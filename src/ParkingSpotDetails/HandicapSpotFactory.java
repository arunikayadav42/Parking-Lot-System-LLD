package ParkingSpotDetails;

import java.util.UUID;

public class HandicapSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(final UUID uid) {
        return new HandicapSpot(uid);
    }
}

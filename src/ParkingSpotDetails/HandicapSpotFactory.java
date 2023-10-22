package ParkingSpotDetails;

import java.util.UUID;

public class HandicapSpotFactory extends ParkingSpotFactory{
    @Override
    protected ParkingSpot createParkingSpot(UUID uid) {
        return new HandicapSpot(uid);
    }
}

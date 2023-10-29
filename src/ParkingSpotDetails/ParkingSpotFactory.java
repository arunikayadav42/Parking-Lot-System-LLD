package ParkingSpotDetails;

import java.util.UUID;

public abstract class ParkingSpotFactory {
    public static ParkingSpot getParkingSpot(String parkingSpotType) {
        UUID uid = UUID.randomUUID();
        switch(parkingSpotType) {
            case "COMPACT":
                return new CompactSpot(uid);
            case "HANDICAP":
                return new HandicapSpot(uid);
            case "LARGE":
                return new LargeSpot(uid);
            case "MOTORCYCLE":
                return new MotorcycleSpot(uid);
            case default: {
                return null;
            }
        }
    }
}

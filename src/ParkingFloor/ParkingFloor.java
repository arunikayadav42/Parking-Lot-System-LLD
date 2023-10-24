package ParkingFloor;

import ParkingLotDetails.DisplayBoard;
import ParkingSpotDetails.CompactSpotFactory;
import ParkingSpotDetails.HandicapSpotFactory;
import ParkingSpotDetails.LargeSpotFactory;
import ParkingSpotDetails.MotorcycleSpotFactory;
import ParkingSpotDetails.ParkingSpot;
import VehicleDetails.Car;
import VehicleDetails.Motorcycle;
import VehicleDetails.Truck;
import VehicleDetails.Van;
import VehicleDetails.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.Constants.TOTAL_COMPACT_SLOTS;
import static utils.Constants.TOTAL_HANDICAP_SLOTS;
import static utils.Constants.TOTAL_LARGE_SLOTS;
import static utils.Constants.TOTAL_MOTORCYCLE_SLOTS;

public class ParkingFloor {
    private Integer parkingFloorID;
    private String parkingFloorName;
    List<ParkingSpot> compactSpotList;
    List<ParkingSpot> handicapSpotList;
    List<ParkingSpot> largeSpotList;
    List<ParkingSpot> motorcycleSpotList;

    private Integer compactSpotOccupiedCount;
    private Integer handicapSpotOccupiedCount;

    private Integer largeSpotOccupiedCount;

    private Integer motorcycleSpotOccupiedCount;

    private DisplayBoard displayBoard;

    public ParkingFloor(Integer id, String name) {
        this.parkingFloorID = id;
        this.parkingFloorName = name;
        this.displayBoard = new DisplayBoard(this);
        this.compactSpotList = new ArrayList<>(Collections.nCopies(TOTAL_COMPACT_SLOTS, new CompactSpotFactory().create()));
        this.handicapSpotList = new ArrayList<>(Collections.nCopies(TOTAL_HANDICAP_SLOTS, new HandicapSpotFactory().create()));
        this.largeSpotList = new ArrayList<>(Collections.nCopies(TOTAL_LARGE_SLOTS, new LargeSpotFactory().create()));
        this.motorcycleSpotList = new ArrayList<>(Collections.nCopies(TOTAL_MOTORCYCLE_SLOTS, new MotorcycleSpotFactory().create()));
        compactSpotOccupiedCount = 0;
        handicapSpotOccupiedCount = 0;
        largeSpotOccupiedCount = 0;
        motorcycleSpotOccupiedCount = 0;
    }

    public static ParkingFloor addParkingFloor(final Integer parkingFloorID, final String parkingFloorName) {
        return new ParkingFloor(parkingFloorID, parkingFloorName);
    }

    public Boolean assignVehicleToParkingSpot(Vehicle vehicle) {
        final ParkingSpot parkingSpot = getFirstAvailableParkingSpot(vehicle);
        if(parkingSpot == null) {
            System.out.println("Sorry, no slots on this floor");
            return false;
        }
        parkingSpot.parkVehicle(vehicle);
        vehicle.setParkingSpot(parkingSpot);
        return true;
    }

    private ParkingSpot getFirstAvailableParkingSpot(final Vehicle vehicle) {
        if(vehicle instanceof Car || vehicle instanceof Van) {
            for(int i = 0; i < TOTAL_COMPACT_SLOTS; i++) {
                if(compactSpotList.get(i).isAvailable()) {
                    compactSpotOccupiedCount++;
                    return compactSpotList.get(i);
                }
            }
//        } else if(vehicle instanceof Motorcycle) {
//            for(int i = 0; i < TOTAL_HANDICAP_SLOTS; i++) {
//                if(handicapSpotList.get(i).isAvailable()) {
//                    handicapSpotOccupiedCount++;
//                    return handicapSpotList.get(i);
//                }
//            }
        } else if(vehicle instanceof Truck) {
            for(int i = 0; i < TOTAL_LARGE_SLOTS; i++) {
                if(largeSpotList.get(i).isAvailable()) {
                    largeSpotOccupiedCount++;
                    return largeSpotList.get(i);
                }
            }
        }   else if(vehicle instanceof Motorcycle) {
            for(int i = 0; i < TOTAL_MOTORCYCLE_SLOTS; i++) {
                if(motorcycleSpotList.get(i).isAvailable()) {
                    motorcycleSpotOccupiedCount++;
                    return motorcycleSpotList.get(i);
                }
            }
        }

        return null;
    }

    public Boolean removeVehicleFromParkingSpot(final Vehicle vehicle) {

        final ParkingSpot parkingSpot = vehicle.getParkingSpot();

        if(vehicle instanceof Car || vehicle instanceof Van) {
            compactSpotOccupiedCount--;
        } else if(vehicle instanceof Motorcycle) {
            motorcycleSpotOccupiedCount--;
        } else if(vehicle instanceof Truck) {
            largeSpotOccupiedCount--;
        }

        parkingSpot.unparkVehicle();

        return null;
    }

    public void display() {
        StringBuilder message = new StringBuilder();
        message.append("PARKING SPOT TYPE             |         Available         |         Total      \n");
        message.append(String.format("COMPACT PARKING SPOTS         |         %d              |          %d\n", TOTAL_COMPACT_SLOTS-compactSpotOccupiedCount, TOTAL_COMPACT_SLOTS));
        message.append(String.format("HANDICAP PARKING SPOTS        |         %d               |          %d\n", TOTAL_HANDICAP_SLOTS-handicapSpotOccupiedCount, TOTAL_HANDICAP_SLOTS));
        message.append(String.format("LARGE PARKING SPOTS           |         %d               |          %d\n", TOTAL_LARGE_SLOTS-largeSpotOccupiedCount, TOTAL_LARGE_SLOTS));
        message.append(String.format("MOTORCYCLE PARKING SPOTS      |         %d               |          %d\n", TOTAL_MOTORCYCLE_SLOTS-motorcycleSpotOccupiedCount, TOTAL_MOTORCYCLE_SLOTS));
        displayBoard.display(message.toString());
    }

}

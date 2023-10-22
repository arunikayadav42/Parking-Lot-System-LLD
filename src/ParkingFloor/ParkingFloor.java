package ParkingFloor;

import ParkingLotDetails.DisplayBoard;
import ParkingSpotDetails.*;
import VehicleDetails.*;
import utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Constants.*;

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
        this.compactSpotList = new ArrayList<>();
        this.handicapSpotList = new ArrayList<>();
        this.largeSpotList = new ArrayList<>();
        this.motorcycleSpotList = new ArrayList<>();
        compactSpotOccupiedCount = 0;
        handicapSpotOccupiedCount = 0;
        largeSpotOccupiedCount = 0;
        motorcycleSpotOccupiedCount = 0;
        createSlots();
    }

    private void createSlots() {
        //assuming each floor has 100 parking spots - dividng them equally so, 25 spots of each kind
        for(int i = 0; i < TOTAL_COMPACT_SLOTS; i++) {
            compactSpotList.add(new CompactSpotFactory().create());
        }

        for(int j = 0; j < TOTAL_HANDICAP_SLOTS; j++) {
            handicapSpotList.add(new HandicapSpotFactory().create());
        }

        for(int i = 0; i < TOTAL_LARGE_SLOTS; i++) {
            largeSpotList.add(new LargeSpotFactory().create());
        }

        for(int i = 0; i < TOTAL_MOTORCYCLE_SLOTS; i++) {
            motorcycleSpotList.add(new MotorcycleSpotFactory().create());
        }
    }


    public static ParkingFloor addParkingFloor(Integer parkingFloorID, String parkingFloorName) {
        return new ParkingFloor(parkingFloorID, parkingFloorName);
    }

    public Boolean assignVehicleToParkingSpot(Vehicle vehicle) {
        ParkingSpot parkingSpot = getFirstAvailableParkingSpot(vehicle);
        if(parkingSpot == null) {
            System.out.println("Sorry, no slots on this floor");
            return false;
        }
        parkingSpot.parkVehicle(vehicle);
        return true;
    }

    private ParkingSpot getFirstAvailableParkingSpot(Vehicle vehicle) {
        if(vehicle instanceof Car ||vehicle instanceof Van) {
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

    public Boolean removeVehicleFromParkingSpot(Vehicle vehicle) {

        ParkingSpot parkingSpot = vehicle.getParkingSpot();

        if(vehicle instanceof Car ||vehicle instanceof Van) {
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
        message.append(String.format("COMPACT PARKING SPOTS         |         {0}               |          {1}\n", compactSpotOccupiedCount, TOTAL_COMPACT_SLOTS));
        message.append(String.format("HANDICAP PARKING SPOTS        |         {0}               |          {1}\n", handicapSpotOccupiedCount, TOTAL_HANDICAP_SLOTS));
        message.append(String.format("LARGE PARKING SPOTS           |         {0}               |          {1}\n", largeSpotOccupiedCount, TOTAL_LARGE_SLOTS));
        message.append(String.format("MOTORCYCLE PARKING SPOTS      |         {0}               |          {1}\n", motorcycleSpotOccupiedCount, TOTAL_MOTORCYCLE_SLOTS));
        displayBoard.display(message.toString());
    }

}

package ParkingFloor;

import ParkingLotDetails.DisplayBoard;
import ParkingSpotDetails.ParkingSpot;
import ParkingSpotDetails.ParkingSpotFactory;
import VehicleDetails.Vehicle;
import VehicleDetails.VisitorPattern.VehicleDispatchVisitor;
import VehicleDetails.VisitorPattern.VehicleDispatchVisitorImpl;
import VehicleDetails.VisitorPattern.VehicleVisitor;
import VehicleDetails.VisitorPattern.VehicleVisitorImpl;

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

    private VehicleVisitor vehicleVisitor;
    private VehicleDispatchVisitor vehicleDispatchVisitor;

    public ParkingFloor(final Integer id, final String name) {
        this.parkingFloorID = id;
        this.parkingFloorName = name;
        this.displayBoard = new DisplayBoard(this);
        this.compactSpotList = new ArrayList<>(Collections.nCopies(TOTAL_COMPACT_SLOTS, ParkingSpotFactory.getParkingSpot("COMPACT")));
        this.handicapSpotList = new ArrayList<>(Collections.nCopies(TOTAL_HANDICAP_SLOTS, ParkingSpotFactory.getParkingSpot("HANDICAP")));
        this.largeSpotList = new ArrayList<>(Collections.nCopies(TOTAL_LARGE_SLOTS, ParkingSpotFactory.getParkingSpot("LARGE")));
        this.motorcycleSpotList = new ArrayList<>(Collections.nCopies(TOTAL_MOTORCYCLE_SLOTS, ParkingSpotFactory.getParkingSpot("MOTORCYCLE")));
        compactSpotOccupiedCount = 0;
        handicapSpotOccupiedCount = 0;
        largeSpotOccupiedCount = 0;
        motorcycleSpotOccupiedCount = 0;
        vehicleVisitor = new VehicleVisitorImpl(this);
        vehicleDispatchVisitor = new VehicleDispatchVisitorImpl(this);
    }

    public static ParkingFloor addParkingFloor(final Integer parkingFloorID, final String parkingFloorName) {
        return new ParkingFloor(parkingFloorID, parkingFloorName);
    }

    public Boolean assignVehicleToParkingSpot(final Vehicle vehicle) {
        vehicle.accept(vehicleVisitor);
        return true;
    }


    public void addCompactParkingSpot(final Vehicle vehicle) {
        for(int i = 0; i < TOTAL_COMPACT_SLOTS; i++) {
            ParkingSpot parkingSpot = compactSpotList.get(i);
            if(parkingSpot.isAvailable()) {
                compactSpotOccupiedCount++;
                parkingSpot.parkVehicle(vehicle);
                vehicle.setParkingSpot(parkingSpot);
            }
        }
    }

    public void addMotorcyleParkingSpot(final Vehicle vehicle) {
        for(int i = 0; i < TOTAL_MOTORCYCLE_SLOTS; i++) {
            ParkingSpot parkingSpot = motorcycleSpotList.get(i);
            if(parkingSpot.isAvailable()) {
                motorcycleSpotOccupiedCount++;
                parkingSpot.parkVehicle(vehicle);
                vehicle.setParkingSpot(parkingSpot);
            }
        }
    }

    public void addLargeParkingSpot(final Vehicle vehicle) {
        for(int i = 0; i < TOTAL_LARGE_SLOTS; i++) {
            ParkingSpot parkingSpot = largeSpotList.get(i);
            if(parkingSpot.isAvailable()) {
                largeSpotOccupiedCount++;
                parkingSpot.parkVehicle(vehicle);
                vehicle.setParkingSpot(parkingSpot);
            }
        }
    }

    public void addHandicapParkingSpot(final Vehicle vehicle) {
        for(int i = 0; i < TOTAL_HANDICAP_SLOTS; i++) {
                ParkingSpot parkingSpot = handicapSpotList.get(i);
                if(parkingSpot.isAvailable()) {
                    handicapSpotOccupiedCount++;
                    parkingSpot.parkVehicle(vehicle);
                    vehicle.setParkingSpot(parkingSpot);
                }
            }
    }

    public Boolean removeVehicleFromParkingSpot(final Vehicle vehicle) {

        final ParkingSpot parkingSpot = vehicle.getParkingSpot();

        vehicle.accept(vehicleDispatchVisitor);

        parkingSpot.unparkVehicle();

        return null;
    }

    public void removeVehicleFromCompactSpot() {
        compactSpotOccupiedCount--;
    }

    public void removeVehicleFromMotorcycleSpot() {
        motorcycleSpotOccupiedCount--;
    }

    public void removeVehicleFromLargeSpot() {
        largeSpotOccupiedCount--;
    }

    public void removeVehicleFromHandicapSpot() {
        handicapSpotOccupiedCount--;
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

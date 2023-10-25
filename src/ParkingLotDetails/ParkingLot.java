package ParkingLotDetails;

import ParkingFloor.Entrance;
import ParkingFloor.Exit;
import ParkingFloor.ParkingFloor;
import ParkingSpotDetails.ParkingSpot;
import PaymentDetails.Payment;
import VehicleDetails.Vehicle;
import utils.Address;
import utils.Constants;
import utils.Counter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParkingLot {

    private Integer id;
    private String name;
    private Address address;

    private List<ParkingFloor> parkingFloorList;

    private HashMap<Integer, Entrance> entranceHashMap;
    private HashMap<Integer, Exit> exitHashMap;

    private Counter counterForParkingTicketID;

    private Integer counterForEntranceID;

    private Integer counterForExitID;

    private static ParkingLot parkingLot;

    //defining a static block to initiate the threads for keeping a thread-safe counter for parking ticket id
    static {
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.THREAD_POOL_SIZE);

        for(int i = 0; i < Constants.THREAD_POOL_SIZE; i++) {
            executorService.submit(new Counter());
        }

        executorService.shutdown();
    }

    private ParkingLot(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        parkingFloorList = new ArrayList<ParkingFloor>();
        entranceHashMap = new HashMap<>();
        exitHashMap = new HashMap<>();
        counterForEntranceID = 0;
        counterForExitID = 0;
        counterForParkingTicketID = new Counter();
    }

    public static ParkingLot getParkingLotInstance() {
        if(parkingLot == null) {
            parkingLot = new ParkingLot(1, "First Parking Lot", new Address());
        }

        return parkingLot;
    }

    public Boolean addParkingFloors(final Integer parkingFloorID, final String parkingFloorName) {
        ParkingFloor parkingFloor = ParkingFloor.addParkingFloor(parkingFloorID, parkingFloorName);
        parkingFloorList.add(parkingFloor);
        return true;
    }

    public void addEntrance() {
        entranceHashMap.put(counterForEntranceID++, new Entrance(counterForEntranceID));
    }

    public void addExit() {
        exitHashMap.put(counterForExitID++, new Exit(counterForExitID));
    }

    public Boolean parkVehicle(final Integer entranceID, final Integer parkingFloorID, final Vehicle vehicle) {
        final ParkingTicket parkingTicket = getParkingTicketAtEntrance(entranceID);

        final Boolean vehicleParked = assignVehicleToParkingSpot(parkingFloorID, vehicle);

        if(vehicleParked == false)
            return false;

        //assign parking ticket to vehicle
        assignParkingTicketToVehicle(vehicle, parkingTicket);

        return true;
    }

    private ParkingTicket getParkingTicketAtEntrance(Integer entranceId) {
        Entrance entrance = entranceHashMap.get(entranceId);

        return entrance.getParkingTicket(Counter.counter);
    }

    private void assignParkingTicketToVehicle(final Vehicle vehicle, final ParkingTicket parkingTicket) {
        //assign parking ticket to vehicle
        vehicle.assignTicket(parkingTicket);
    }

    private Boolean assignVehicleToParkingSpot(final Integer parkingFloorID, final Vehicle vehicle) {
        if(parkingFloorList.size()-1 < parkingFloorID)
            {
                System.out.println("Parking Lot does not contain a parking at this level, please enter a valid level");
                return false;
            }

        //get the floor on which to park
        ParkingFloor parkingFloor = parkingFloorList.get(parkingFloorID);
        //assign vehicle to parking slot
        parkingFloor.assignVehicleToParkingSpot(vehicle);

        return true;
    }

    public void unparkVehicle(final Vehicle vehicle, final Payment paymentMode, final Integer exitID, final Integer parkingFloorID) {
        final ParkingFloor parkingFloor = parkingFloorList.get(parkingFloorID);
        final ParkingTicket parkingTicket = vehicle.getParkingTicket();

        //get the amount
        final Double amount = calculateRate(parkingTicket, exitID);

        //make the payment
        makePaymentAtExit(paymentMode, amount);

        //unpark the vehicle from the spot and make it free
        removeVehicleFromParkingSpot(vehicle, parkingFloor);
    }

    private Double calculateRate(final ParkingTicket parkingTicket, final Integer exitID) {
        //set the end time of the parking ticket
        parkingTicket.setEndTime(new Timestamp(LocalTime.now().toEpochSecond(LocalDate.now(), ZoneOffset.UTC)));

        //calculate the parking rate
        Exit exit = exitHashMap.get(exitID);
        return exit.calculateRate(parkingTicket);
    }

    private void makePaymentAtExit(final Payment paymentMode, final Double amount) {
        paymentMode.makePayment(amount);
    }

    private Boolean removeVehicleFromParkingSpot(final Vehicle vehicle, final ParkingFloor parkingFloor) {
        return parkingFloor.removeVehicleFromParkingSpot(vehicle);
    }

    public void display(final Integer parkingFloorID) {
        parkingFloorList.get(parkingFloorID).display();
    }
}

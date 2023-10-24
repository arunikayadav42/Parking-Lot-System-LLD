import ParkingLotDetails.ParkingAgent;
import ParkingLotDetails.ParkingLot;
import PaymentDetails.Cash;
import VehicleDetails.Car;
import VehicleDetails.Vehicle;

public class CommandExecutor {
    public static void main(String[] args) {
        System.out.println("Designing the parking lot system");

        System.out.println("Getting the parking lot instance");
        ParkingLot parkingLot = ParkingLot.getParkingLotInstance();
        ParkingAgent parkingAgent = new ParkingAgent();

        parkingLot.addParkingFloors(0, "Ground Level");
        parkingLot.addParkingFloors(1, "First Level");
        parkingLot.addParkingFloors(2, "Second Level");
        parkingLot.addParkingFloors(3, "Second Level");
        parkingLot.addEntrance();
        parkingLot.addEntrance();
        parkingLot.addEntrance();
        parkingLot.addExit();
        parkingLot.addExit();

        parkingLot.display(0);

        Vehicle vehicle = new Car("UP78 1234", "BLUE");
        parkingLot.parkVehicle(0, 0, vehicle);
        parkingLot.display(0);
        parkingLot.unparkVehicle(vehicle, new Cash(), 0, 0);
    }
}
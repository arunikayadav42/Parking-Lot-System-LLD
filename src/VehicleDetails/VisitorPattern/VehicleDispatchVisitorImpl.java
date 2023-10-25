package VehicleDetails.VisitorPattern;

import ParkingFloor.ParkingFloor;
import VehicleDetails.Car;
import VehicleDetails.Motorcycle;
import VehicleDetails.Truck;
import VehicleDetails.Van;

public class VehicleDispatchVisitorImpl implements VehicleDispatchVisior{

    private final ParkingFloor parkingFloor;

    public VehicleDispatchVisitorImpl(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    @Override
    public void visit(Car car) {
        parkingFloor.removeVehicleFromCompactSpot();
    }

    @Override
    public void visit(Truck truck) {
        parkingFloor.removeVehicleFromLargeSpot();
    }

    @Override
    public void visit(Van van) {
        parkingFloor.removeVehicleFromHandicapSpot();
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        parkingFloor.removeVehicleFromMotorcycleSpot();
    }
}

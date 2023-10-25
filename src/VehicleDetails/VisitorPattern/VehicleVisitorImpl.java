package VehicleDetails.VisitorPattern;

import ParkingFloor.ParkingFloor;
import VehicleDetails.Car;
import VehicleDetails.Motorcycle;
import VehicleDetails.Truck;
import VehicleDetails.Van;

public class VehicleVisitorImpl implements VehicleVisitor {

    private final ParkingFloor parkingFloor;

    public VehicleVisitorImpl(final ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
    @Override
    public void visit(Car car) {
        parkingFloor.addCompactParkingSpot(car);
    }

    @Override
    public void visit(Truck truck) {
        parkingFloor.addLargeParkingSpot(truck);
    }

    @Override
    public void visit(Van van) {
        parkingFloor.addHandicapParkingSpot(van);
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        parkingFloor.addMotorcyleParkingSpot(motorcycle);
    }
}

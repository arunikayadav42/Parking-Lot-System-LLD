package VehicleDetails.VisitorPattern;

import VehicleDetails.Car;
import VehicleDetails.Motorcycle;
import VehicleDetails.Truck;
import VehicleDetails.Van;

public interface VehicleVisitor {
    void visit(Car car);

    void visit(Truck truck);

    void visit(Van van);
    void visit(Motorcycle motorcycle);
}

package ParkingLotDetails;

import ParkingFloor.ParkingFloor;

public class DisplayBoard {
    private ParkingFloor parkingFloor;


    public DisplayBoard(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public void display(String message) {
        System.out.println(message);
    }
}

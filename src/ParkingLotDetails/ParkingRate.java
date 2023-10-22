package ParkingLotDetails;

public class ParkingRate {
    private Double rate;

    public ParkingRate(Double rate) {
        this.rate = rate;
    }
    public Double calculateRate(Integer time) {
        return rate*time;
    }
}

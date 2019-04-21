package model;

public class ParkingSpace {

    private FixedStack<Vehicle> vehicles;

    protected Integer slots;

    public ParkingSpace(Integer slots){

        this.slots=slots;

        vehicles=new FixedStack<>(slots);
    }

    public FixedStack<Vehicle> getVehicles() {
        return vehicles;
    }

}

package model;


/**@author Meghna Tolani
 * ParkingSpace : Represents one parking space in a parking lot
 * */

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

package model;

/**@author Meghna Tolani
 * Vehicle : Represents vehicle being parked at a parking space could be of type Car or Bike
 * */

public class Vehicle {

    private Travellers travellers;

    private String vehicleNumber;

    protected Integer slotsNeeded;

    private String vehicleType;

    public Vehicle(){
    }

    public Vehicle(Travellers travellers, String vehicleNumber){
        this.setTravellers(travellers);
        this.setVehicleNumber(vehicleNumber);
        setSlotsNeeded();
    }

    public void setTravellers(Travellers travellers) {
        this.travellers = travellers;
    }


    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setSlotsNeeded(){
        if(this instanceof Car){
            vehicleType = "CAR";
            slotsNeeded = 2;
        }
        else{
            slotsNeeded = 5;
            vehicleType= "BIKE";
        }

    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Travellers getTravellers() {
        return travellers;
    }
}

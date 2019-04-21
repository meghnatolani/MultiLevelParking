package service;

import model.*;

public class ParkingSpaceServiceImpl implements ParkingLotService{

    public Integer addParkingSpace( ParkingLot parkingLot, Vehicle vehicle){

        String parkingDone=null;

        ParkingSpace[][] parkingSpaces = parkingLot.getParkingSpaces();

        if(vehicle instanceof Car){

            outerloop : for(int i = 0; i< parkingSpaces[0].length ; i++) {

                for (int j = 3; j >= 2; j--) {

                    FixedStack<Vehicle> vehicles = parkingSpaces[j][i].getVehicles();

                    if(vehicles.checkSpace()) {

                        vehicles.push(vehicle);

                        parkingDone= ""+j+i;

                        break outerloop;

                    }
                }
            }
        } else {
            outerloop : for (int i = parkingSpaces[0].length-1 ; i >= 0  ; i--){

                for (int j = 1; j >= 0; j--){

                    FixedStack<Vehicle> vehicles = parkingSpaces[j][i].getVehicles();

                    if (vehicles.checkSpace()) {

                        vehicles.push(vehicle);

                        parkingDone = ""+j + i;

                        break outerloop;
                    }

                }
            }
        }

        if(parkingDone!=null && vehicle.getTravellers().isRoyal())
            fillSlotsAround(parkingDone,parkingSpaces);

        return parkingLot.getHashMap().get(parkingDone);

    }


    public void fillSlotsAround(String parkingSlotNumber, ParkingSpace[][] parkingSpaces){

        int i=Character.getNumericValue(parkingSlotNumber.charAt(0));

        int j=Character.getNumericValue(parkingSlotNumber.charAt(1));

        while(!parkingSpaces[i][j].getVehicles().isFull())
            parkingSpaces[i][j].getVehicles().push(new Vehicle());

    }


}

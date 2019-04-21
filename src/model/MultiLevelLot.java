package model;

import java.util.LinkedHashMap;

/**@author Meghna Tolani
 * MultiLevelLot : Represents N levels of parking
 * */

public class MultiLevelLot {

    private static MultiLevelLot multiLevelLot = null;

    private Integer numberOfLevels;

    private LinkedHashMap<ParkingLot,Integer[]> parkingLots;

    /*
    * Every Parking lot has space for 20 cars and 50 bikes
    * Stored them in arr[0] and arr[1]
    * */
    private MultiLevelLot(Integer numberOfLevels){

        this.numberOfLevels = numberOfLevels;

        parkingLots=new LinkedHashMap<>();

        for(int level=0;level<numberOfLevels;level++){

            parkingLots.put(new ParkingLot(level) , new Integer[]{20,50});
        }
    }

    public static MultiLevelLot getInstance(int numberOfLevels){
        if(multiLevelLot ==null )
            multiLevelLot = new MultiLevelLot(numberOfLevels);
        return multiLevelLot;
    }


    public LinkedHashMap<ParkingLot, Integer[]> getParkingLots() {
        return parkingLots;
    }
}
